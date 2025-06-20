@Test public void testGet(){
  Jboot.getCache().put("cachename","key","value");
  String value=Jboot.getCache().get("cachename","key");
  Assert.assertTrue("value".equals(value));
}
