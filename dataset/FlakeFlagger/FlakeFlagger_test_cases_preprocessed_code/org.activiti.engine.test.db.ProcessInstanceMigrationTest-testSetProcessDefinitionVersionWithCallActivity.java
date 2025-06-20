@Deployment(resources={TEST_PROCESS_CALL_ACTIVITY}) public void testSetProcessDefinitionVersionWithCallActivity(){
assertNotNull(execution);
assertEquals(2,repositoryService.createProcessDefinitionQuery().processDefinitionKey("parentProcess").count());
assertEquals(0,runtimeService.createProcessInstanceQuery().processInstanceId(pi.getId()).count());
}