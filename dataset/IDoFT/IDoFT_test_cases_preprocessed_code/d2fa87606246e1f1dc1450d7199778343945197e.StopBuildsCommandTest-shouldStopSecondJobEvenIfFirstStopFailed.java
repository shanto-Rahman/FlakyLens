@Test public void shouldStopSecondJobEvenIfFirstStopFailed() throws Exception {
assertThat(stdout,equalTo("Exception occurred while trying to stop build '#1' for job 'jobName'. " + "Exception class: AccessDeniedException3, message: anonymous is missing the Job/Cancel permission" + LN + "Build '#1' stopped for job 'jobName2'"+ LN));
}