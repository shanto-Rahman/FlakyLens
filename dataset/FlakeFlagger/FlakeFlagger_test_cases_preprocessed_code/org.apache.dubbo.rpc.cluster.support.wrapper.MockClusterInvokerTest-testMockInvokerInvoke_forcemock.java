/** 
 * Test if mock policy works fine: force-mock
 */
@Test public void testMockInvokerInvoke_forcemock(){
Assert.assertEquals("aa",ret.getValue());
Assert.assertEquals(null,ret.getValue());
Assert.assertEquals(null,ret.getValue());
}