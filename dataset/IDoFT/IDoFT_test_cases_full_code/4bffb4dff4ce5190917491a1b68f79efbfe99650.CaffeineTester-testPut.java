@Test public void testPut(){
  Jboot.getCache().put(cacheName,"key","value");
  String value=Jboot.getCache().get(cacheName,"key");
  Assert.assertNotNull(value);
}
