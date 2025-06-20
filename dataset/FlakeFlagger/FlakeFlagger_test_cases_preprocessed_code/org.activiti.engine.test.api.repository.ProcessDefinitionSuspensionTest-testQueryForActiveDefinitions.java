@Deployment(resources={"org/activiti/engine/test/db/processOne.bpmn20.xml","org/activiti/engine/test/db/processTwo.bpmn20.xml"}) public void testQueryForActiveDefinitions(){
assertEquals(2,processDefinitionList.size());
assertEquals(2,repositoryService.createProcessDefinitionQuery().active().count());
assertEquals(2,repositoryService.createProcessDefinitionQuery().count());
assertEquals(1,repositoryService.createProcessDefinitionQuery().active().count());
}