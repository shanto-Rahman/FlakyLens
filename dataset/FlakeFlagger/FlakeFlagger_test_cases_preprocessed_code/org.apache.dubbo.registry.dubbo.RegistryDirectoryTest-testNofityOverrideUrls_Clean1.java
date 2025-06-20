/** 
 * Test cleanup override rules, and sent remove rules and other override rules Whether the test can be restored to the providerUrl when it is pushed
 */
@Test public void testNofityOverrideUrls_Clean1(){
Assert.assertEquals("1",aInvoker.getUrl().getParameter("timeout"));
}