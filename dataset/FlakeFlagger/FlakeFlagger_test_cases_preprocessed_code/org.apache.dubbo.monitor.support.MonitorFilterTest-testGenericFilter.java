@Test public void testGenericFilter() throws Exception {
Thread.sleep(10);
Assert.assertEquals("abc",lastStatistics.getParameter(MonitorService.APPLICATION));
Assert.assertEquals(MonitorService.class.getName(),lastStatistics.getParameter(MonitorService.INTERFACE));
Assert.assertEquals("xxx",lastStatistics.getParameter(MonitorService.METHOD));
Assert.assertEquals(NetUtils.getLocalHost() + ":20880",lastStatistics.getParameter(MonitorService.PROVIDER));
Assert.assertEquals(NetUtils.getLocalHost(),lastStatistics.getAddress());
Assert.assertEquals(null,lastStatistics.getParameter(MonitorService.CONSUMER));
Assert.assertEquals(1,lastStatistics.getParameter(MonitorService.SUCCESS,0));
Assert.assertEquals(0,lastStatistics.getParameter(MonitorService.FAILURE,0));
Assert.assertEquals(1,lastStatistics.getParameter(MonitorService.CONCURRENT,0));
Assert.assertEquals(invocation,lastInvocation);
}