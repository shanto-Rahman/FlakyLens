@Deployment public void testExpression(){
assertEquals(1,managementService.createTimerJobQuery().processInstanceId(pi1.getId()).count());
assertEquals(1,managementService.createTimerJobQuery().processInstanceId(pi2.getId()).count());
assertEquals(2,jobs.size());
assertEquals(0,managementService.createTimerJobQuery().processInstanceId(pi1.getId()).count());
assertEquals(0,managementService.createTimerJobQuery().processInstanceId(pi2.getId()).count());
}