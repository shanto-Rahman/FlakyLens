@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testDelayedActivateProcessDefinition(){
fail();
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
assertEquals(0,repositoryService.createProcessDefinitionQuery().active().count());
assertEquals(1,repositoryService.createProcessDefinitionQuery().suspended().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,repositoryService.createProcessDefinitionQuery().active().count());
assertEquals(0,repositoryService.createProcessDefinitionQuery().suspended().count());
}