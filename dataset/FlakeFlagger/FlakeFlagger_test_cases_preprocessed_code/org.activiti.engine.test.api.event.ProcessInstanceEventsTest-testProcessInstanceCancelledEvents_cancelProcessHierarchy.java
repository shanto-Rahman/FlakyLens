@Deployment(resources={"org/activiti/engine/test/api/runtime/nestedSubProcess.bpmn20.xml","org/activiti/engine/test/api/runtime/subProcess.bpmn20.xml"}) public void testProcessInstanceCancelledEvents_cancelProcessHierarchy() throws Exception {
assertNotNull(processInstance);
listener.clearEventsReceived();//IT
assertEquals("ActivitiEventType.PROCESS_CANCELLED was expected 2 times.",2,processCancelledEvents.size());
assertTrue("The cause has to be the same as deleteProcessInstance method call",ActivitiCancelledEvent.class.isAssignableFrom(processCancelledEvent.getClass()));
assertEquals("The process instance has to be the same as in deleteProcessInstance method call",subProcess.getId(),processCancelledEvent.getProcessInstanceId());
assertEquals("The execution instance has to be the same as in deleteProcessInstance method call",subProcess.getId(),processCancelledEvent.getExecutionId());
assertEquals("The cause has to be the same as in deleteProcessInstance method call","delete_test",processCancelledEvent.getCause());
assertTrue("The cause has to be the same as deleteProcessInstance method call",ActivitiCancelledEvent.class.isAssignableFrom(processCancelledEvent.getClass()));
assertEquals("The process instance has to be the same as in deleteProcessInstance method call",processInstance.getId(),processCancelledEvent.getProcessInstanceId());
assertEquals("The execution instance has to be the same as in deleteProcessInstance method call",processInstance.getId(),processCancelledEvent.getExecutionId());
assertEquals("The cause has to be the same as in deleteProcessInstance method call","delete_test",processCancelledEvent.getCause());
assertEquals("No task can be active for deleted process.",0,this.taskService.createTaskQuery().processInstanceId(processInstance.getId()).count());
assertEquals("ActivitiEventType.ACTIVITY_CANCELLED was expected 1 time.",1,taskCancelledEvents.size());
assertTrue("The cause has to be the same as deleteProcessInstance method call",ActivitiActivityCancelledEvent.class.isAssignableFrom(activityCancelledEvent.getClass()));
assertEquals("The process instance has to point to the subprocess",subProcess.getId(),activityCancelledEvent.getProcessInstanceId());
assertEquals("The cause has to be the same as in deleteProcessInstance method call","delete_test",activityCancelledEvent.getCause());
listener.clearEventsReceived();//IT
}