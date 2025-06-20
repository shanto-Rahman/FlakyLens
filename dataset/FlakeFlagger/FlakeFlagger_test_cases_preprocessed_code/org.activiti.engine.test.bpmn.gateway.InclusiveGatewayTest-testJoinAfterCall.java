@Deployment(resources={"org/activiti/engine/test/bpmn/gateway/InclusiveGatewayTest.testJoinAfterCall.bpmn20.xml","org/activiti/engine/test/bpmn/gateway/InclusiveGatewayTest.testJoinAfterCallSubProcess.bpmn20.xml"}) public void testJoinAfterCall(){
assertNotNull(processInstance.getId());
assertEquals(3,taskService.createTaskQuery().count());
assertNotNull(taskA);
assertEquals(2,taskService.createTaskQuery().count());
assertNotNull(taskB);
assertEquals(1,taskService.createTaskQuery().count());
assertNotNull(taskC);
assertEquals(1,taskService.createTaskQuery().count());
assertNotNull(taskD);
assertEquals("Task D",taskD.getName());
assertNull(processInstance);
}