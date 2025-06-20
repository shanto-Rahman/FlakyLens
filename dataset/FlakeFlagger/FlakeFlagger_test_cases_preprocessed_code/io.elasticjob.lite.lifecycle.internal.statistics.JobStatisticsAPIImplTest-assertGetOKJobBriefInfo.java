@Test public void assertGetOKJobBriefInfo(){
assertThat(jobBrief.getJobName(),is("test_job"));
assertThat(jobBrief.getDescription(),is("desc"));
assertThat(jobBrief.getCron(),is("0/1 * * * * ?"));
assertThat(jobBrief.getInstanceCount(),is(2));
assertThat(jobBrief.getShardingTotalCount(),is(3));
assertThat(jobBrief.getStatus(),Is.is(JobBriefInfo.JobStatus.OK));
}