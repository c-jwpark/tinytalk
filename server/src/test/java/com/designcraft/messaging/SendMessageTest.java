package com.designcraft.messaging;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.designcraft.infra.messaging.MessageBody;
import com.designcraft.infra.messaging.MessageSender;
import com.designcraft.infra.messaging.jackson.JacksonMessageBody;
import com.designcraft.infra.messaging.mqtt.MqttSender;

public class SendMessageTest {
	static class SendingObject {
		private String filed1;
		private List<String> filed2;
		
		// json에 포함될 필드는 반드시 getter를 가져야 함
		public String getField1() {
			return filed1;
		}

		// json에 포함될 필드는 반드시 getter를 가져야 함
		public List<String> getField2() {
			return filed2;
		}
		
		public SendingObject() {
			this.filed1 = "00011112222";
			filed2 = new ArrayList<String>();
			filed2.add("00011112222");
			filed2.add("00022223333");
		}
	}

	@Test
	// Object를 json으로 만들고, 그 json을 mqtt를 통해서 client에 전달하는 예제
	public void testSendMessage() throws IOException {
		// make msg body
		SendingObject obj = new SendingObject();
		MessageBody messageBody = new JacksonMessageBody();
		String messageJson = messageBody.makeMessageBody(obj);
		System.out.println(messageJson);

		// send message
		MessageSender msgSender = new MqttSender();
		List<String> receivers = new ArrayList<String>();
		receivers.add("1111");
		receivers.add("2222");
		receivers.add("3333");
		msgSender.sendMessage(receivers, messageJson);
	}
}
