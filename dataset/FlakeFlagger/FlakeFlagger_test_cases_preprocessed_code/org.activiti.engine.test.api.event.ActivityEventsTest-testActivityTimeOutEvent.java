@Deployment(resources="org/activiti/engine/test/api/event/JobEventsTest.testJobEntityEvents.bpmn20.xml") public void testActivityTimeOutEvent(){
assertNotNull(theJob);
assertEquals(1,listener.getEventsReceived().size());
assertEquals("ACTIVITY_CANCELLED event expected",ActivitiEventType.ACTIVITY_CANCELLED,activitiEvent.getType());
assertTrue("TIMER is the cause of the cancellation",cancelledEvent.getCause() instanceof JobEntity);
}