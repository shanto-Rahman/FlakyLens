@Test public void assertJobInit(){
  while (!((DetailedFooJob)getElasticJob()).isCompleted()) {
    BlockUtils.waitingShortTime();
  }
  assertTrue(getREGISTRY_CENTER().isExisted("/" + getJobName() + "/sharding"));
}
