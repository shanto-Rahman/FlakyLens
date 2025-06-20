public void testProcessDefinitionQuery(){
assertEquals(2,processDefinitions.size());
assertEquals(4,repositoryService.createProcessDefinitionQuery().orderByProcessDefinitionName().asc().count());
assertEquals(2,repositoryService.createProcessDefinitionQuery().latestVersion().orderByProcessDefinitionName().asc().count());
}