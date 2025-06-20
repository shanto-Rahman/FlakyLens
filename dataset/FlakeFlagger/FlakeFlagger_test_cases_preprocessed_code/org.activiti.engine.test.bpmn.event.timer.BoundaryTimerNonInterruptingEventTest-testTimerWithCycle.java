@Deployment public void testTimerWithCycle() throws Exception {
assertEquals(1,jobs.size());
assertEquals(1,managementService.createTimerJobQuery().processInstanceId(processInstanceId).count());
assertEquals(1,managementService.createTimerJobQuery().processInstanceId(processInstanceId).count());
fail("No more jobs since the user completed the task");
}