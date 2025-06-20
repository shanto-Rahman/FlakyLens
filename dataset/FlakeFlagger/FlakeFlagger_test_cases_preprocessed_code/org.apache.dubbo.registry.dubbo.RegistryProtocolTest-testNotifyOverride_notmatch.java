/** 
 * The name of the service does not match and can't override invoker Service name matching, service version number mismatch
 */
@Test public void testNotifyOverride_notmatch() throws Exception {
assertEquals(true,exporter.getInvoker().isAvailable());
assertEquals(null,exporter.getInvoker().getUrl().getParameter("timeout"));
}