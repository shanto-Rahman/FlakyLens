@Test public void assertGetCrashedJobBriefInfo(){
assertThat(jobBrief.getStatus(),Is.is(JobBriefInfo.JobStatus.CRASHED));
}