public void testSuspendMultipleProcessDefinitionsByKey(){
assertEquals(nrOfProcessDefinitions,repositoryService.createProcessDefinitionQuery().count());
assertEquals(nrOfProcessDefinitions,repositoryService.createProcessDefinitionQuery().active().count());
assertEquals(0,repositoryService.createProcessDefinitionQuery().suspended().count());
assertEquals(nrOfProcessDefinitions,repositoryService.createProcessDefinitionQuery().count());
assertEquals(0,repositoryService.createProcessDefinitionQuery().active().count());
assertEquals(nrOfProcessDefinitions,repositoryService.createProcessDefinitionQuery().suspended().count());
assertEquals(nrOfProcessDefinitions,repositoryService.createProcessDefinitionQuery().count());
assertEquals(nrOfProcessDefinitions,repositoryService.createProcessDefinitionQuery().active().count());
assertEquals(0,repositoryService.createProcessDefinitionQuery().suspended().count());
assertEquals(nrOfProcessDefinitions,repositoryService.createProcessDefinitionQuery().count());
assertEquals(0,repositoryService.createProcessDefinitionQuery().active().count());
assertEquals(nrOfProcessDefinitions,repositoryService.createProcessDefinitionQuery().suspended().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().suspended().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().active().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
}