@Deployment(resources={"org/activiti/engine/test/bpmn/callactivity/CallActivity.testSubProcessDataInputOutput.bpmn20.xml","org/activiti/engine/test/bpmn/callactivity/simpleSubProcess.bpmn20.xml"}) public void testSubProcessWithDataInputOutput(){
assertEquals("Task in subprocess",taskBeforeSubProcess.getName());
assertEquals("Hello from the super process.",runtimeService.getVariable(taskBeforeSubProcess.getProcessInstanceId(),"subVariable"));
assertEquals("Hello from the super process.",taskService.getVariable(taskBeforeSubProcess.getId(),"subVariable"));
assertEquals("Hello from the super process.",runtimeService.getVariable(processInstance.getId(),"superVariable"));
assertEquals("Task in super process",taskAfterSubProcess.getName());
assertEquals("Hello from sub process.",runtimeService.getVariable(processInstance.getId(),"superVariable"));
assertEquals("Hello from sub process.",taskService.getVariable(taskAfterSubProcess.getId(),"superVariable"));
assertEquals("Task in subprocess",taskInSecondSubProcess.getName());
assertEquals(10l,runtimeService.getVariable(taskInSecondSubProcess.getProcessInstanceId(),"y"));
assertEquals(10l,taskService.getVariable(taskInSecondSubProcess.getId(),"y"));
assertEquals("Task in super process",taskAfterSecondSubProcess.getName());
assertEquals(15l,runtimeService.getVariable(taskAfterSecondSubProcess.getProcessInstanceId(),"z"));
assertEquals(15l,taskService.getVariable(taskAfterSecondSubProcess.getId(),"z"));
assertEquals(0,runtimeService.createExecutionQuery().list().size());
}