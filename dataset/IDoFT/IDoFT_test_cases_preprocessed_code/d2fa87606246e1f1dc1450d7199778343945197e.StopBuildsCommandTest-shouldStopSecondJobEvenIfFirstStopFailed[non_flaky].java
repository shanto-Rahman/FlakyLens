@Test public void shouldStopSecondJobEvenIfFirstStopFailed() throws Exception {
assertThat(testList,contains("Exception occurred while trying to stop build '#1' for job 'jobName'. " + "Exception class: AccessDeniedException3, message: anonymous is missing the Job/Cancel permission","Build '#1' stopped for job 'jobName2'"));
}