/** 
 * Test whether the override rule have a high priority Scene: push override rules with invoker
 */
@Test public void testNotifyoverrideUrls_withInvoker(){
Assert.assertEquals(true,registryDirectory.isAvailable());
Assert.assertEquals(2,invokers.size());
Assert.assertEquals("override rute must be first priority","1",invokers.get(0).getUrl().getParameter("timeout"));
Assert.assertEquals("override rute must be first priority","5",invokers.get(0).getUrl().getParameter("connections"));
}