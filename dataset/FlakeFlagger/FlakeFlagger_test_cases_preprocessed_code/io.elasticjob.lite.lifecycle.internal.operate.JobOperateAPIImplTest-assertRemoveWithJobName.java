@Test public void assertRemoveWithJobName(){
assertFalse(regCenter.isExisted("/test_job/servers/ip1"));
assertFalse(regCenter.isExisted("/test_job/servers/ip2"));
assertTrue(regCenter.isExisted("/test_job"));
}