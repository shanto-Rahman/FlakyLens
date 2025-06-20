@Test public void test_received_request_twoway_error_reqeustBroken() throws RemotingException {
Assert.assertEquals(request.getId(),res.getId());
Assert.assertEquals(request.getVersion(),res.getVersion());
Assert.assertEquals(Response.BAD_REQUEST,res.getStatus());
Assert.assertNull(res.getResult());
Assert.assertTrue(res.getErrorMessage().contains(BizException.class.getName()));
count.incrementAndGet();
Assert.assertEquals(1,count.get());
}