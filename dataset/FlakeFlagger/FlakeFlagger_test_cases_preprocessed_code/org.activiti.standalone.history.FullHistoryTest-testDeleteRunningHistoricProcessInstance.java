@Deployment public void testDeleteRunningHistoricProcessInstance(){
assertNotNull(processInstance);
fail("Exception expected when deleting process-instance that is still running");
}