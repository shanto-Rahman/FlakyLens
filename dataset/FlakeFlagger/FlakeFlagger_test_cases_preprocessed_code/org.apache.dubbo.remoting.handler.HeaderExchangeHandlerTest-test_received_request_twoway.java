@Test public void test_received_request_twoway() throws RemotingException {
Assert.assertEquals(request.getId(),res.getId());
Assert.assertEquals(request.getVersion(),res.getVersion());
Assert.assertEquals(Response.OK,res.getStatus());
Assert.assertEquals(requestdata,res.getResult());
Assert.assertEquals(null,res.getErrorMessage());
count.incrementAndGet();
return CompletableFuture.completedFuture(request);
Assert.fail();
Assert.assertEquals(1,count.get());
}