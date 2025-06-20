@Test public void shouldStopWorkingBuildsInSeveralJobs() throws Exception {
  final List<String> inputJobNames=asList(TEST_JOB_NAME,TEST_JOB_NAME_2);
  setupAndAssertTwoBuildsStop(inputJobNames);
}
