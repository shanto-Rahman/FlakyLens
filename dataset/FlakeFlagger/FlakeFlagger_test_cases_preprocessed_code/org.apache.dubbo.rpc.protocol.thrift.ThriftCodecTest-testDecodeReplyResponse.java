@Test public void testDecodeReplyResponse() throws Exception {
Assert.assertNotNull(obj);
Assert.assertEquals(true,obj instanceof Response);
Assert.assertEquals(request.getId(),response.getId());
Assert.assertTrue(response.getResult() instanceof RpcResult);
Assert.assertTrue(result.getResult() instanceof String);
Assert.assertEquals(methodResult.success,result.getResult());
}