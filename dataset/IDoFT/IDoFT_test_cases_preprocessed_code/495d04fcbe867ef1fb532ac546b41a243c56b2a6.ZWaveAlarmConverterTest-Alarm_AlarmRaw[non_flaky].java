@Test public void Alarm_AlarmRaw(){
assertTrue(stateStr.contains("\"notification\":\"ACCESS_CONTROL__KEYPAD_UNLOCK\""));
assertTrue(stateStr.contains("\"level\":\"0\""));
assertTrue(stateStr.contains("\"type\":\"ACCESS_CONTROL\""));
assertTrue(stateStr.contains("\"event\":\"6\""));
assertTrue(stateStr.contains("\"status\":\"255\""));
}