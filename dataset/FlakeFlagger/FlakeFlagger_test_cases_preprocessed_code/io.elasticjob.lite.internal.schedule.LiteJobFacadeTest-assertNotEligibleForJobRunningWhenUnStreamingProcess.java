@Test public void assertNotEligibleForJobRunningWhenUnStreamingProcess(){
assertThat(liteJobFacade.isEligibleForJobRunning(),is(false));
}