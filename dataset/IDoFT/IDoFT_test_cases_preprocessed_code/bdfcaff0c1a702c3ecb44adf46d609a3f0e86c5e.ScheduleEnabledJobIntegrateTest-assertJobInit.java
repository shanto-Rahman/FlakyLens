@Test public void assertJobInit(){
assertTrue(getREGISTRY_CENTER().isExisted("/" + getJobName() + "/sharding"));
}