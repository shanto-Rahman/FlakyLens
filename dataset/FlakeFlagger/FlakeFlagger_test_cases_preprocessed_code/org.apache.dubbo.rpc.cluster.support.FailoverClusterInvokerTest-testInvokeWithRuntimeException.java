@Test public void testInvokeWithRuntimeException(){
fail();
assertEquals(0,expected.getCode());
assertFalse(expected.getCause() instanceof RpcException);
}