@Test public void testMonitor() throws Exception {
TestCase.assertEquals("monitor-addr",interfaceConfig.getMonitor().getAddress());
TestCase.assertSame(monitorConfig,interfaceConfig.getMonitor());
}