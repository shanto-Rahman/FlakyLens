@Test() public void testNoInvoke(){
fail();
assertFalse(expected.getCause() instanceof RpcException);
}