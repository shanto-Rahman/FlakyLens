@Test public void assertGetDisabledJobBriefInfo(){
assertThat(jobBrief.getStatus(),Is.is(JobBriefInfo.JobStatus.DISABLED));
}