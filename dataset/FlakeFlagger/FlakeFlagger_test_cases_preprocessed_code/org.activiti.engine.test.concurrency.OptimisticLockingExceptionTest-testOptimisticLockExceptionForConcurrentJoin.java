@Test @Deployment(resources={"org/activiti/engine/test/concurrency/CompetingJoinTest.testCompetingJoins.bpmn20.xml"}) public void testOptimisticLockExceptionForConcurrentJoin() throws Exception {
t1.start();
t2.start();
OptimisticLockingTestCommandContextCloseListener.TEST_BARRIER_BEFORE_CLOSE.await();//RW
while (t1.getException() == null && t2.getException() == null && runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).count() == 1) {
  Thread.sleep(250L);
  totalWaitTime+=250L;
  if (totalWaitTime >= 5000L) {
    break;
  }
}//IT
Thread.sleep(250L);
if (totalWaitTime >= 5000L) {
}
if ((t1.getException() != null && t1.getException() instanceof ActivitiOptimisticLockingException) || (t2.getException() != null && t2.getException() instanceof ActivitiOptimisticLockingException)) {//IT
}
Assert.assertTrue(processInstanceEnded);
Assert.assertTrue(optimisticLockingExceptionHappenedOnce);
}