@Test public void assertGetAllJobsBriefInfoWithoutNamespace(){
assertThat(jobStatisticsAPI.getAllJobsBriefInfo().size(),is(0));
}