@org.activiti.engine.test.Deployment public void testSetProcessDefinitionCategory(){
assertEquals("testCategory",processDefinition.getCategory());
assertNotNull(processDefinition);
assertTrue(newCount == count + 1);
assertEquals(0,repositoryService.createProcessDefinitionQuery().processDefinitionCategory("testCategory").count());
assertNotNull(processDefinition);
assertTrue(newCount == count + 2);
assertEquals(0,repositoryService.createProcessDefinitionQuery().processDefinitionCategory("testCategory").count());
assertEquals(0,repositoryService.createProcessDefinitionQuery().processDefinitionCategory("UpdatedCategory").count());
assertEquals(1,repositoryService.createProcessDefinitionQuery().processDefinitionCategoryNotEquals("UpdatedCategory").count());
}