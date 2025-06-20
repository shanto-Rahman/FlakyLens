@Test public void serverSocketReadsTcpPushWhenBufferIsSmallerThanInput() throws UnknownHostException, IOException, InterruptedException {
  checkServerSocketReadsTcpPushWhenBufferSizeIs(TEXT,4);
}
