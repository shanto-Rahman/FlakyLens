@Test public void testDecodeExceptionResponse() throws Exception {
Assert.assertNotNull(obj);
Assert.assertTrue(obj instanceof Response);
Assert.assertTrue(response.getResult() instanceof RpcResult);
Assert.assertTrue(result.hasException());
Assert.assertTrue(result.getException() instanceof RpcException);
}