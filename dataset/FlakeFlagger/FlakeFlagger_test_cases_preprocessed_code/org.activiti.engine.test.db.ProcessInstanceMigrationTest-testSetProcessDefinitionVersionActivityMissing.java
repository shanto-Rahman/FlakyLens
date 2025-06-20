@Deployment(resources={TEST_PROCESS}) public void testSetProcessDefinitionVersionActivityMissing(){
assertNotNull(execution);
assertEquals(2,repositoryService.createProcessDefinitionQuery().count());
fail("ActivitiException expected");
}