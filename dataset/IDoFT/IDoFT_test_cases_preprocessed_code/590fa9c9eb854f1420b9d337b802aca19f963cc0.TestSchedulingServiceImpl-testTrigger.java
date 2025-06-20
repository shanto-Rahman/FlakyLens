public void testTrigger(){
assertTrue(service.isScheduled(callbacks[3]));
assertTrue(service.isScheduled(callbacks[0]));
assertTrue(service.isScheduled(callbacks[3]));
assertFalse(service.isScheduled(callbacks[3]));
assertFalse(service.isScheduled(callbacks[3]));
assertEquals(0,callbacks[3].clearAndGetOrderTriggered());//IT
SupportScheduleCallback.setCallbackOrderNum(0);//IT
}