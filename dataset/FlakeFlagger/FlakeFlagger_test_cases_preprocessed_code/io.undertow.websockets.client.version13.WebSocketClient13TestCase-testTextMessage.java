@Test public void testTextMessage() throws Exception {
final WebSocketChannel webSocketChannel=WebSocketClient.connect(worker,buffer,OptionMap.EMPTY,new URI(DefaultServer.getDefaultServerURL()),WebSocketVersion.V13).get();//RW
if (r != null) {
result.set(FileUtils.readFile(stream));
latch.countDown();
}
latch.countDown();
latch.await(10,TimeUnit.SECONDS);
Assert.assertEquals("Hello World",result.get());
}