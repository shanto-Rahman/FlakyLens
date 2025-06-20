@Test public void testNotCloseZkWhenPending() throws Exception {
RO_ZK.zookeeper=mockedZK;//RW
CompletableFuture<byte[]> future=RO_ZK.get(PATH);//RW
Thread.sleep(6000);
assertNotNull(RO_ZK.zookeeper);//RW
callback.processResult(Code.OK.intValue(),PATH,null,DATA,null);//RW
assertArrayEquals(DATA,future.get());//RW
}