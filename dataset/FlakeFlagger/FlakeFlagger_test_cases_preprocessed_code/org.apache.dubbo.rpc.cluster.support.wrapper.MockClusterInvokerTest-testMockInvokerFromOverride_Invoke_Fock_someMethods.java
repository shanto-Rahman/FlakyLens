/** 
 * Test if mock policy works fine: fail-mock
 */
@Test public void testMockInvokerFromOverride_Invoke_Fock_someMethods(){
Assert.assertEquals("something",ret.getValue());
Assert.assertEquals("y",ret.getValue());
Assert.assertEquals("something3",ret.getValue());
Assert.assertEquals(null,ret.getValue());
}