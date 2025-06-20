@Test public void discoverService() throws Exception {
  registry.doRegister(serviceUrl);
  List<URL> urls=registry.doDiscover(serviceUrl);
  Assert.assertTrue(urls.isEmpty());
  registry.doAvailable(null);
  Thread.sleep(sleepTime);
  System.out.println("Before discovery");
  try {
    urls=registry.doDiscover(serviceUrl);
  }
 catch (  Exception e) {
    e.printStackTrace();
  }
  Assert.assertTrue(urls.contains(serviceUrl));
}
