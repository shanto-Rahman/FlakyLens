@Test public void Alarm_AlarmRaw(){
  ZWaveAlarmConverter converter=new ZWaveAlarmConverter(null);
  Map<String,String> args=new HashMap<String,String>();
  ZWaveThingChannel channel=new ZWaveThingChannel(null,new ChannelTypeUID("zwave:alarm_raw"),new ChannelUID("zwave:node:bridge:alarm_raw"),DataType.StringType,CommandClass.COMMAND_CLASS_ALARM.toString(),0,args);
  ZWaveCommandClassValueEvent event=createEvent(AlarmType.ACCESS_CONTROL,ReportType.NOTIFICATION,6,255);
  StringType state=(StringType)converter.handleEvent(channel,event);
  assertEquals("{\"notification\":\"ACCESS_CONTROL__KEYPAD_UNLOCK\",\"level\":\"0\",\"type\":\"ACCESS_CONTROL\",\"event\":\"6\",\"status\":\"255\"}",state.toString());
}
