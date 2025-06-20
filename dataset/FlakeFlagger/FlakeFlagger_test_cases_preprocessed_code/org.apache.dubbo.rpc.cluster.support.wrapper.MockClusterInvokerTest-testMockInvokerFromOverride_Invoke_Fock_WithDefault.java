/** 
 * Test if mock policy works fine: fail-mock
 */
@Test public void testMockInvokerFromOverride_Invoke_Fock_WithDefault(){
Assert.assertEquals("x",ret.getValue());
Assert.assertEquals("y",ret.getValue());
Assert.assertEquals(null,ret.getValue());
Assert.assertEquals(null,ret.getValue());
}