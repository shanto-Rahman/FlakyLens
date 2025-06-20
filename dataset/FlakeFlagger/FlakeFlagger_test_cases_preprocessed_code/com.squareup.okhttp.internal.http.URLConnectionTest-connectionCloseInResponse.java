@Test public void connectionCloseInResponse() throws IOException, InterruptedException {
assertEquals(200,a.getResponseCode());
assertEquals(200,b.getResponseCode());
assertEquals(0,server.takeRequest().getSequenceNumber());
assertEquals("When connection: close is used, each request should get its own connection",0,server.takeRequest().getSequenceNumber());
}