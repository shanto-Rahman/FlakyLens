@Test public void testSimpleBasic() throws Exception {
final ClientConnection connection=client.connect(ADDRESS,worker,new ByteBufferSlicePool(1024,1024),OptionMap.EMPTY).get();//RW
latch.await(10,TimeUnit.MINUTES);
Assert.assertEquals(10,responses.size());
Assert.assertEquals(message,response.getAttachment(RESPONSE_BODY));
}