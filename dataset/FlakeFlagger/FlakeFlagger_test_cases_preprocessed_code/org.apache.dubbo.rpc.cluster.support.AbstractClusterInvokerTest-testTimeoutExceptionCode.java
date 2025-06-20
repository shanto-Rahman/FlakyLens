@Test() public void testTimeoutExceptionCode(){
Assert.fail();
Assert.assertEquals(RpcException.TIMEOUT_EXCEPTION,e.getCode());
Assert.fail();
Assert.assertEquals(RpcException.TIMEOUT_EXCEPTION,e.getCode());
Assert.fail();
Assert.assertEquals(RpcException.TIMEOUT_EXCEPTION,e.getCode());
}