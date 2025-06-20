@Test public void testPut(){
  Jboot.getCache().put("cachename","key","value");
  String value=Jboot.getCache().get("cachename","key");
  Assert.assertNotNull(value);
}
