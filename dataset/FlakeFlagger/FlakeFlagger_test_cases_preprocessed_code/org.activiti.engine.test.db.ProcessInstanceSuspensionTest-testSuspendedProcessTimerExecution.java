@Deployment public void testSuspendedProcessTimerExecution() throws Exception {
assertNotNull(procInst);
assertEquals(1,managementService.createTimerJobQuery().processInstanceId(procInst.getId()).count());
assertEquals(1,jobs.size());
assertEquals(0,jobs.size());
}