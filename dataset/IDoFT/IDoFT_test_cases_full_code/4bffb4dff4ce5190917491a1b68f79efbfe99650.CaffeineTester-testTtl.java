@Test public void testTtl() throws InterruptedException {
  JbootCache cache=Jboot.getCache();
  cache.put(cacheName,"key","value~~~~~~~",10);
  for (int i=0; i < 10; i++) {
    System.out.println(cache.getTtl(cacheName,"key"));
    Thread.sleep(1000);
  }
}
