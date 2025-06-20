@Test public void testMonitorFactoryGroupCache() throws Exception {
if (monitor1 == null || monitor2 == null) {
Thread.sleep(2000);
}
Assert.assertNotSame(monitor1,monitor2);
}