@Test public void testMonitorFactory() throws Exception {
if (monitor == null) {
}
Thread.sleep(10);
Assert.assertEquals(1,result.getParameter(MonitorService.SUCCESS,0));
Assert.assertEquals(3,result.getParameter(MonitorService.ELAPSED,0));
Assert.assertNotNull(monitor);
}