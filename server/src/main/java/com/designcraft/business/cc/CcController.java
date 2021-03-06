package com.designcraft.business.cc;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.designcraft.business.txtmsg.TxtMsgController;
import com.designcraft.business.usage.UsageManager;
import com.designcraft.infra.db.AbstractDBFactory;
import com.designcraft.infra.db.SetDB;
import com.designcraft.infra.db.redis.RedisDBFactory;
import com.designcraft.infra.messaging.MessageBody;
import com.designcraft.infra.messaging.MessageSender;
import com.designcraft.infra.messaging.MessageTemplate;
import com.designcraft.infra.messaging.jackson.JacksonMessageBody;
import com.designcraft.infra.messaging.mqtt.MqttSender;

import io.swagger.model.CCRequestInformation;

public class CcController {
	private SetDB mCcSet;
//	private KeyValueDB mCcHash;
	
	protected static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private String mCcNumber;
	private String mStartTime;
	private String mEndTime;
	private String mOwner;
	private List<String> mListMember;
	
	public CcController () {
		AbstractDBFactory dbFactory = new RedisDBFactory();
		mCcSet = dbFactory.createSetDB();
//		mCcHash = dbFactory.createKeyValueDB();
	}
	
	/*
	 * Conference Call Request
	 *   create id of conference call
	 */
	public void create(CCRequestInformation ccrequest, String sender) {
		mStartTime = ccrequest.getStartDatetime();
		mEndTime = ccrequest.getEndDatetime();
		mOwner = sender;
		mListMember = ccrequest.getMembers();
		
		StringBuilder sb = new StringBuilder();
		
		Collections.sort(mListMember);
		for ( String member : mListMember )
			sb.append(member).append("-");
		
		sb.deleteCharAt(sb.length() - 1);
		mCcNumber = sb.toString();	// we cannot allow duplicate cc id that consists of same members.
	}

	public String makeInvitationMsg() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[Conference Call] Start : ")
		.append(mStartTime)
		.append(", End : ")
		.append(mEndTime)
		.append(", Number : ")
		.append(mCcNumber);
		
		return sb.toString();
	}
	
	public List<String> startCall(String ccNumber, String sender, String ipOfSender) throws IOException {
		List<String> ips = new ArrayList<String>();
		List<String> members = new ArrayList<String>();
		Set<String> participants = mCcSet.get("cccall:" + ccNumber);
		for ( String receiver : participants) {
			String[] arr = receiver.split(":");
			members.add(arr[0]);
			ips.add(arr[1]);
		}
		
		NewJoin nj = new NewJoin(ccNumber, ipOfSender);

		MessageBody messageBody = new JacksonMessageBody();
		MessageSender msgSender = new MqttSender();
		
		MessageTemplate template = new MessageTemplate("ccNewJoin", nj);
		String messageJson = messageBody.makeMessageBody(template);
		
		for ( String receiver : members )
			msgSender.sendMessage(receiver, messageJson);
		
		mCcSet.add("cccall:" + ccNumber, sender + ":" + ipOfSender);
		new UsageManager().callStart(sender);
		
		return ips;
	}
	
	public void endCall(String ccNumber, String sender) throws IOException {
		new UsageManager().dropReferenceCall(sender);
		
		String ipOfSender = null;
		List<String> members = new ArrayList<String>();
		Set<String> participants = mCcSet.get("cccall:" + ccNumber);
		for ( String receiver : participants) {
			String[] arr = receiver.split(":");
			if ( sender.equals(arr[0]) ) {
				ipOfSender = arr[1];
				mCcSet.del("cccall:" + ccNumber, receiver);
			}
			else
				members.add(arr[0]);
		}
		
		CallDrop cd = new CallDrop(ccNumber, ipOfSender);
		
		MessageBody messageBody = new JacksonMessageBody();
		MessageSender msgSender = new MqttSender();
		
		MessageTemplate template = new MessageTemplate("ccCallDrop", cd);
		String messageJson = messageBody.makeMessageBody(template);

		for ( String receiver : members )
			msgSender.sendMessage(receiver, messageJson);
	}
}
