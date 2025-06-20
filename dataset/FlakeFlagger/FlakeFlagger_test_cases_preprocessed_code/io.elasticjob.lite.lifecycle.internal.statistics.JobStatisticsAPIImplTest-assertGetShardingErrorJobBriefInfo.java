@Test public void assertGetShardingErrorJobBriefInfo(){
assertThat(jobBrief.getStatus(),Is.is(JobBriefInfo.JobStatus.SHARDING_FLAG));
}