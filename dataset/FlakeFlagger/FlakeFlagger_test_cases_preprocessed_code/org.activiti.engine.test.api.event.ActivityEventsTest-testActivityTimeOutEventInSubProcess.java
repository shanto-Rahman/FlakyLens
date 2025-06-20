@Deployment(resources="org/activiti/engine/test/bpmn/event/timer/BoundaryTimerEventTest.testTimerOnNestingOfSubprocesses.bpmn20.xml") public void testActivityTimeOutEventInSubProcess(){
assertNotNull(theJob);
assertEquals(4,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ACTIVITY_CANCELLED,event.getType());
assertTrue("TIMER is the cause of the cancellation",((ActivitiActivityCancelledEvent)event).getCause() instanceof JobEntity);
assertTrue(eventIdList.indexOf("innerTask1") >= 0);
assertTrue(eventIdList.indexOf("innerTask2") >= 0);
assertTrue(eventIdList.indexOf("subprocess") >= 0);
assertTrue(eventIdList.indexOf("innerSubprocess") >= 0);
}