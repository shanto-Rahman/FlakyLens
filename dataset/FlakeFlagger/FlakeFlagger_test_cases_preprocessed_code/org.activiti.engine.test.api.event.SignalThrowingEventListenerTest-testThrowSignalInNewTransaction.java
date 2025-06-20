/** 
 * Test signal throwing when a job failed and the retries are decremented, affectively starting a new transaction.
 */
@Deployment public void testThrowSignalInNewTransaction() throws Exception {
assertNotNull(processInstance);
fail("Exception expected");
assertNotNull(failedJob);
assertEquals(2,failedJob.getRetries());
assertEquals(1,taskService.createTaskQuery().processInstanceId(processInstance.getId()).count());
fail("Exception expected");
assertEquals(2,taskService.createTaskQuery().processInstanceId(processInstance.getId()).count());
}