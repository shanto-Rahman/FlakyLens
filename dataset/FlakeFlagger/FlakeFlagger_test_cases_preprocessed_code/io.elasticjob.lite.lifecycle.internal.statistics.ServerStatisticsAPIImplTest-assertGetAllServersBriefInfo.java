@Test public void assertGetAllServersBriefInfo(){
assertThat(each.getServerIp(),is("ip" + i));
assertThat(each.getDisabledJobsNum().intValue(),is(2));
assertThat(each.getJobsNum(),is(2));
assertThat(each.getInstancesNum(),is(1));
assertThat(each.getDisabledJobsNum().intValue(),is(1));
assertThat(each.getJobsNum(),is(2));
assertThat(each.getInstancesNum(),is(1));
fail();
}