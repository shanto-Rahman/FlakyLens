@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testProcessInstanceCancelledEvents_cancel() throws Exception {
assertNotNull(processInstance);
listener.clearEventsReceived();//IT
assertEquals("ActivitiEventType.PROCESS_CANCELLED was expected 1 time.",1,processCancelledEvents.size());
assertTrue("The cause has to be the same as deleteProcessInstance method call",ActivitiCancelledEvent.class.isAssignableFrom(processCancelledEvent.getClass()));
assertEquals("The process instance has to be the same as in deleteProcessInstance method call",processInstance.getId(),processCancelledEvent.getProcessInstanceId());
assertEquals("The execution instance has to be the same as in deleteProcessInstance method call",processInstance.getId(),processCancelledEvent.getExecutionId());
assertEquals("The cause has to be the same as in deleteProcessInstance method call","delete_test",processCancelledEvent.getCause());
assertEquals("ActivitiEventType.ACTIVITY_CANCELLED was expected 1 time.",1,taskCancelledEvents.size());
assertTrue("The cause has to be the same as deleteProcessInstance method call",ActivitiActivityCancelledEvent.class.isAssignableFrom(activityCancelledEvent.getClass()));
assertEquals("The process instance has to be the same as in deleteProcessInstance method call",processInstance.getId(),activityCancelledEvent.getProcessInstanceId());
assertEquals("The cause has to be the same as in deleteProcessInstance method call","delete_test",activityCancelledEvent.getCause());
listener.clearEventsReceived();//IT
}