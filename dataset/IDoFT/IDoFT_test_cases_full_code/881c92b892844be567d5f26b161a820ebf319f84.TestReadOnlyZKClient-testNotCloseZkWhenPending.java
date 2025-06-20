@Test public void testNotCloseZkWhenPending() throws Exception {
  ZooKeeper mockedZK=mock(ZooKeeper.class);
  Exchanger<AsyncCallback.DataCallback> exchanger=new Exchanger<>();
  doAnswer(i -> {
    exchanger.exchange(i.getArgument(2));
    return null;
  }
).when(mockedZK).getData(anyString(),anyBoolean(),any(AsyncCallback.DataCallback.class),any());
  doAnswer(i -> null).when(mockedZK).close();
  when(mockedZK.getState()).thenReturn(ZooKeeper.States.CONNECTED);
  RO_ZK.zookeeper=mockedZK;
  CompletableFuture<byte[]> future=RO_ZK.get(PATH);
  AsyncCallback.DataCallback callback=exchanger.exchange(null);
  Thread.sleep(6000);
  assertNotNull(RO_ZK.zookeeper);
  verify(mockedZK,never()).close();
  callback.processResult(Code.OK.intValue(),PATH,null,DATA,null);
  assertArrayEquals(DATA,future.get());
  waitForIdleConnectionClosed();
  verify(mockedZK,times(1)).close();
}
