@Test public void assertGetAllJobsBriefInfo(){
assertThat(each.getJobName(),is("test_job_" + i));
assertThat(each.getDescription(),is("desc" + i));
assertThat(each.getCron(),is("0/1 * * * * ?"));
assertThat(each.getInstanceCount(),is(2));
assertThat(each.getShardingTotalCount(),is(3));
assertThat(each.getStatus(),Is.is(JobBriefInfo.JobStatus.OK));
}