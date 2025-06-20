@Test public void testMonitorFactoryIpCache() throws Exception {
if (monitor1 == null || monitor2 == null) {
Thread.sleep(2000);
}
Assert.assertEquals(monitor1,monitor2);
}