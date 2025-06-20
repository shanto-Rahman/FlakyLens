@Test public void assertNotEligibleForJobRunningWhenNeedSharding(){
assertThat(liteJobFacade.isEligibleForJobRunning(),is(false));
}