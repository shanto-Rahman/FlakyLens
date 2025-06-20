@Test public void testDue() throws InterruptedException {
  JbootCache cache=Jboot.getCache();
  cache.put(cacheName,"key","value~~~~~~~",10);
  for (int i=0; i < 15; i++) {
    System.out.println((String)cache.get(cacheName,"key"));
    Thread.sleep(1000);
  }
}
