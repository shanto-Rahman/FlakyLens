@Test @Deployment public void testGetVariableEquals(){
  ProcessInstance processInstance=runtimeService.startProcessInstanceByKey("testExpressionFunction");
  assertEquals("B",taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult().getName());
  processInstance=runtimeService.createProcessInstanceBuilder().processDefinitionKey("testExpressionFunction").variable("myVar",12).start();
  assertEquals("B",taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult().getName());
  processInstance=runtimeService.createProcessInstanceBuilder().processDefinitionKey("testExpressionFunction").variable("myVar",123).start();
  assertEquals("A",taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult().getName());
}
