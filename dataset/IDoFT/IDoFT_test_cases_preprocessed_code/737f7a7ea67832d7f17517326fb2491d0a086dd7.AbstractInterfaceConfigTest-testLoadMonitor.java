@Test public void testLoadMonitor() throws Exception {
TestCase.assertEquals("monitor-addr:12080",url.getAddress());
TestCase.assertEquals(MonitorService.class.getName(),url.getParameter("interface"));
TestCase.assertNotNull(url.getParameter("dubbo"));
TestCase.assertNotNull(url.getParameter("pid"));
TestCase.assertNotNull(url.getParameter("timestamp"));
}