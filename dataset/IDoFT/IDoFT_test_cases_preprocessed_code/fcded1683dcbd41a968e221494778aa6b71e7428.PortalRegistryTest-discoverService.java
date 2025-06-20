@Test public void discoverService() throws Exception {
Assert.assertTrue(urls.isEmpty());
Thread.sleep(sleepTime);
Assert.assertTrue(urls.contains(serviceUrl));
}