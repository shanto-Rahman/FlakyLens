@Deployment(resources={"org/activiti/engine/test/api/event/SignalThrowingEventListenerTest.testThrowSignalInNewTransaction.bpmn20.xml"}) public void testThrowSignalInRolledbackTransaction() throws Exception {
assertNotNull(processInstance);
fail("Exception expected");
assertNotNull("Expected job with exception, found no such job",failedJob);
assertEquals(2,failedJob.getRetries());
assertEquals(0,taskService.createTaskQuery().processInstanceId(processInstance.getId()).count());
fail("Exception expected");
assertEquals(0,taskService.createTaskQuery().processInstanceId(processInstance.getId()).count());
}