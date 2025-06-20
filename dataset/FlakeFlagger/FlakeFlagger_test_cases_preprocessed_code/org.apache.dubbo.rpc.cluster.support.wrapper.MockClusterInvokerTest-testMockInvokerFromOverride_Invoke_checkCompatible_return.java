/** 
 * Test if mock policy works fine: fail-mock
 */
@Test public void testMockInvokerFromOverride_Invoke_checkCompatible_return(){
Assert.assertEquals("x",ret.getValue());
Assert.fail("fail invoke");
}