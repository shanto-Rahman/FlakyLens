/** 
 * Test if mock policy works fine: fail-mock
 */
@Test public void testMockInvokerInvoke_normal(){
Assert.assertEquals("something",ret.getValue());
Assert.assertEquals(null,ret.getValue());
}