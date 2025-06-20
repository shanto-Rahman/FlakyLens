@Test public void testConnectionClose() throws Exception {
final ClientConnection connection=client.connect(ADDRESS,worker,new ByteBufferSlicePool(1024,1024),OptionMap.EMPTY).get();//RW
latch.await();
Assert.assertEquals(message,response.getAttachment(RESPONSE_BODY));
Assert.fail();
}