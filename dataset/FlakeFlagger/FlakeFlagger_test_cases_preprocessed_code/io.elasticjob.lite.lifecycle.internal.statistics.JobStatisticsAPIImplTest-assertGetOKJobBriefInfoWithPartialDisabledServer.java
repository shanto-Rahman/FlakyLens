@Test public void assertGetOKJobBriefInfoWithPartialDisabledServer(){
assertThat(jobBrief.getStatus(),Is.is(JobBriefInfo.JobStatus.OK));
}