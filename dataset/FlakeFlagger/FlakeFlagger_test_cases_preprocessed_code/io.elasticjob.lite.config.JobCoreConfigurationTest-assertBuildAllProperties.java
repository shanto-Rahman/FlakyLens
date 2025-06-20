@Test public void assertBuildAllProperties(){
assertThat(actual.getShardingItemParameters(),is("0=a,1=b,2=c"));
assertThat(actual.getJobParameter(),is("param"));
assertTrue(actual.isFailover());
assertFalse(actual.isMisfire());
assertThat(actual.getDescription(),is("desc"));
assertThat(actual.getJobProperties().get(JobProperties.JobPropertiesEnum.JOB_EXCEPTION_HANDLER),is(IgnoreJobExceptionHandler.class.getName()));
}