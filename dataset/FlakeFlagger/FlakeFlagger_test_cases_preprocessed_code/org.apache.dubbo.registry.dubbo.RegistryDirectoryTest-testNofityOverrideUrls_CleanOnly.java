/** 
 * The test clears the override rule and only sends the override cleanup rules Whether the test can be restored to the providerUrl when it is pushed
 */
@Test public void testNofityOverrideUrls_CleanOnly(){
Assert.assertEquals(null,registryDirectory.getUrl().getParameter("mock"));
Assert.assertEquals("1000",aInvoker.getUrl().getParameter("timeout"));
Assert.assertEquals("fail",registryDirectory.getUrl().getParameter("mock"));
Assert.assertEquals("1",aInvoker.getUrl().getParameter("timeout"));
Assert.assertEquals(null,registryDirectory.getUrl().getParameter("mock"));
}