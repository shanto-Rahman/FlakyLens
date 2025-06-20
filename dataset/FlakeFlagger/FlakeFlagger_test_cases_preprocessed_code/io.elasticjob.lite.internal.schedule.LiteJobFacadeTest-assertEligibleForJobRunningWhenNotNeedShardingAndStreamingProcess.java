@Test public void assertEligibleForJobRunningWhenNotNeedShardingAndStreamingProcess(){
assertThat(liteJobFacade.isEligibleForJobRunning(),is(true));
}