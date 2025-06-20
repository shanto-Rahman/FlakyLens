@Deployment public void testActivityTimeOutEventInCallActivity(){
assertNotNull(theJob);
assertEquals(4,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ACTIVITY_CANCELLED,event.getType());
assertTrue("TIMER is the cause of the cancellation",((ActivitiActivityCancelledEvent)event).getCause() instanceof JobEntity);
assertTrue(eventIdList.contains("innerTask1"));
assertTrue(eventIdList.contains("innerTask2"));
assertTrue(eventIdList.contains("callActivity"));
assertTrue(eventIdList.contains("innerSubprocess"));
}