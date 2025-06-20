@Test public void assertGetWhenValueIsNotEmpty() throws NoSuchFieldException {
assertThat(actual.get(JobProperties.JobPropertiesEnum.JOB_EXCEPTION_HANDLER),is(IgnoreJobExceptionHandler.class.getCanonicalName()));
}