@Test public void testMockInvokerFromOverride_Invoke_force_throwCustemExceptionNotFound(){
Assert.fail();
Assert.assertTrue(e.getCause() instanceof IllegalStateException);
}