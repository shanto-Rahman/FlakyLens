@Test public void assertGetJobsTotalCount(){
assertThat(jobStatisticsAPI.getJobsTotalCount(),is(2));
}