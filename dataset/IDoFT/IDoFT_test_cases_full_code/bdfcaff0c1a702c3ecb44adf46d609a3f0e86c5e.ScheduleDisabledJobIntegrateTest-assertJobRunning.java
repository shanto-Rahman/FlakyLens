@Test public void assertJobRunning(){
  BlockUtils.waitingShortTime();
  assertDisabledRegCenterInfo();
  setJobEnable();
  while (!((DetailedFooJob)getElasticJob()).isCompleted()) {
    BlockUtils.waitingShortTime();
  }
  assertEnabledRegCenterInfo();
}
