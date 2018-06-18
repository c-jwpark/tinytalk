package com.lge.architect.tinytalk.command;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.lge.architect.tinytalk.command.MqttClientService;

public class BootCompleteReceiver extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
    if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
      context.startService(new Intent(context, MqttClientService.class));
    }
  }
}
