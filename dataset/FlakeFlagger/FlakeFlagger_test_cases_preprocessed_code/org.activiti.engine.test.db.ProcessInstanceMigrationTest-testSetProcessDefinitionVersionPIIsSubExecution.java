@Deployment(resources={TEST_PROCESS_WITH_PARALLEL_GATEWAY}) public void testSetProcessDefinitionVersionPIIsSubExecution(){
fail("ActivitiException expected");
}