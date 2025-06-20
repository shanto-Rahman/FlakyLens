@Deployment(resources={TEST_PROCESS}) public void testSetProcessDefinitionVersionNonExistingPD(){
fail("ActivitiException expected");
assertEquals(ProcessDefinition.class,ae.getObjectClass());
}