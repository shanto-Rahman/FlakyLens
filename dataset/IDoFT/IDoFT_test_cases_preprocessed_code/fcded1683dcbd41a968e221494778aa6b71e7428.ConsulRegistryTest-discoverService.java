@Test public void discoverService() throws Exception {
Assert.assertEquals(0,urls.size());
Thread.sleep(sleepTime);
Assert.assertTrue(urls.contains(serviceUrl));
}