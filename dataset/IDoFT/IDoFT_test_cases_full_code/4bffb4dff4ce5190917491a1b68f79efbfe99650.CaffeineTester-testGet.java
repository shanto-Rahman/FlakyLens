@Test public void testGet(){
  JbootCache cache=Jboot.getCache();
  cache.put(cacheName,"key","value~~~~~~~");
  String value=cache.get(cacheName,"key");
  System.out.println("value:" + value);
  Assert.assertTrue("value~~~~~~~".equals(value));
}
