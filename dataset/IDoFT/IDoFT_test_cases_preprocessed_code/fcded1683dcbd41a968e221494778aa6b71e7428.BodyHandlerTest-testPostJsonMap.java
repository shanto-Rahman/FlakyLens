@Test public void testPostJsonMap() throws Exception {
latch.await(10,TimeUnit.SECONDS);
Assert.assertEquals("{key1:value1,key2:value2}",reference.get().getAttachment(Http2Client.RESPONSE_BODY));
}