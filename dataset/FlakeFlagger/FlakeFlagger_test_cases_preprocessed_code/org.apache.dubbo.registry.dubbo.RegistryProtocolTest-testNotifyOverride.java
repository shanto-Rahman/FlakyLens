@Test public void testNotifyOverride() throws Exception {
assertEquals(true,exporter.getInvoker().isAvailable());
assertEquals("100",exporter.getInvoker().getUrl().getParameter("timeout"));
assertEquals("y",exporter.getInvoker().getUrl().getParameter("x"));
}