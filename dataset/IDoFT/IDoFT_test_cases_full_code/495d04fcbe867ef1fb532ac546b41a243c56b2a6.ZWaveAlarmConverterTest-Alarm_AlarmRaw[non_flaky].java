@Test public void Alarm_AlarmRaw(){
  ZWaveAlarmConverter converter=new ZWaveAlarmConverter(null);
  Map<String,String> args=new HashMap<String,String>();
  ZWaveThingChannel channel=new ZWaveThingChannel(null,new ChannelTypeUID("zwave:alarm_raw"),new ChannelUID("zwave:node:bridge:alarm_raw"),DataType.StringType,CommandClass.COMMAND_CLASS_ALARM.toString(),0,args);
  ZWaveCommandClassValueEvent event=createEvent(AlarmType.ACCESS_CONTROL,ReportType.NOTIFICATION,6,255);
  StringType state=(StringType)converter.handleEvent(channel,event);
  String stateStr=state.toString();
  assertTrue(stateStr.contains("\"notification\":\"ACCESS_CONTROL__KEYPAD_UNLOCK\""));
  assertTrue(stateStr.contains("\"level\":\"0\""));
  assertTrue(stateStr.contains("\"type\":\"ACCESS_CONTROL\""));
  assertTrue(stateStr.contains("\"event\":\"6\""));
  assertTrue(stateStr.contains("\"status\":\"255\""));
}
