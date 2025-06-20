@Test public void testClearRpcContext(){
Assert.assertTrue("set attachment failed!",attachments != null && attachments.size() == 1);
Assert.fail();
Assert.assertTrue("Succeeded to forking invoke provider !",expected.getMessage().contains("Failed to forking invoke provider"));
assertFalse(expected.getCause() instanceof RpcException);
Assert.assertTrue("clear attachment failed!",afterInvoke != null && afterInvoke.size() == 0);
}