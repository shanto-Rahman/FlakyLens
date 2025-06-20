@Test public void assertGetJobsBriefInfoByIp(){
assertThat(each.getJobName(),is("test_job_" + ++i));
if (i == 1) {
assertThat(each.getInstanceCount(),is(1));
assertThat(each.getStatus(),Is.is(JobBriefInfo.JobStatus.OK));
if (i == 2) {
assertThat(each.getInstanceCount(),is(0));
assertThat(each.getStatus(),Is.is(JobBriefInfo.JobStatus.DISABLED));
}
}
}