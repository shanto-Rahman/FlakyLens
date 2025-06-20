/** 
 * Test override rules for a certain provider
 */
@Test public void testNofityOverrideUrls_Provider(){
Assert.assertEquals("3",aInvoker.getUrl().getParameter("timeout"));
Assert.assertEquals("4",bInvoker.getUrl().getParameter("timeout"));
}