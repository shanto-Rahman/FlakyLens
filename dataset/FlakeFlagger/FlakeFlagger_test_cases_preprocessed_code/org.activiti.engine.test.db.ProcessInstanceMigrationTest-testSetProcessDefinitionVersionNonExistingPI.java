public void testSetProcessDefinitionVersionNonExistingPI(){
fail("ActivitiException expected");
assertEquals(ProcessInstance.class,ae.getObjectClass());
}