@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testDelayedSuspendProcessDefinition(){
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,repositoryService.createProcessDefinitionQuery().active().count());
assertEquals(0,repositoryService.createProcessDefinitionQuery().suspended().count());
assertEquals(1,managementService.createTimerJobQuery().processDefinitionId(processDefinition.getId()).count());
assertEquals(0,managementService.createJobQuery().processDefinitionId(processDefinition.getId()).count());
assertEquals(0,managementService.createTimerJobQuery().processDefinitionId(processDefinition.getId()).count());
fail();
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(0,repositoryService.createProcessDefinitionQuery().active().count());
assertEquals(1,repositoryService.createProcessDefinitionQuery().suspended().count());
assertEquals(2,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,repositoryService.createProcessDefinitionQuery().active().count());
assertEquals(0,repositoryService.createProcessDefinitionQuery().suspended().count());
}