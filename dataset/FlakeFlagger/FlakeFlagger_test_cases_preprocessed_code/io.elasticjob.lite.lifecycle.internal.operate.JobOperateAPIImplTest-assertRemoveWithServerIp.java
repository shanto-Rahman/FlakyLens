@Test public void assertRemoveWithServerIp(){
assertFalse(regCenter.isExisted("/test_job1/servers/ip1"));
assertFalse(regCenter.isExisted("/test_job2/servers/ip1"));
}