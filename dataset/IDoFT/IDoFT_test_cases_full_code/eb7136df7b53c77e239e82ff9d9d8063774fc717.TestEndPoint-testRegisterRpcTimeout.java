@Test public void testRegisterRpcTimeout() throws Exception {
  final long rpcTimeout=1000;
  final long tolerance=200;
  scmServerImpl.setRpcResponseDelay(1500);
  long start=Time.monotonicNow();
  registerTaskHelper(serverAddress,1000,false).close();
  long end=Time.monotonicNow();
  scmServerImpl.setRpcResponseDelay(0);
  Assert.assertThat(end - start,lessThanOrEqualTo(rpcTimeout + tolerance));
}
