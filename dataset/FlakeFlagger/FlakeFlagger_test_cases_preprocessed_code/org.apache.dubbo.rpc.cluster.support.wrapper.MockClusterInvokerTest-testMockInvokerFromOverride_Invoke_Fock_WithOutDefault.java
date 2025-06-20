/** 
 * Test if mock policy works fine: fail-mock
 */
@Test public void testMockInvokerFromOverride_Invoke_Fock_WithOutDefault(){
Assert.assertEquals("x",ret.getValue());
Assert.assertEquals("y",ret.getValue());
Assert.fail();
}