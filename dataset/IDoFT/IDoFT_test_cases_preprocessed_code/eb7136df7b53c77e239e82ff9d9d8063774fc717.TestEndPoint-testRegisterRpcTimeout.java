@Test public void testRegisterRpcTimeout() throws Exception {
scmServerImpl.setRpcResponseDelay(1500);//RW
registerTaskHelper(serverAddress,1000,false).close();//RW
scmServerImpl.setRpcResponseDelay(0);//RW
Assert.assertThat(end - start,lessThanOrEqualTo(rpcTimeout + tolerance));
}