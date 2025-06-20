@Test public void connectionCloseWithRedirect() throws IOException, InterruptedException {
assertEquals("This is the new location!",readAscii(connection.getInputStream(),Integer.MAX_VALUE));
assertEquals(0,server.takeRequest().getSequenceNumber());
assertEquals("When connection: close is used, each request should get its own connection",0,server.takeRequest().getSequenceNumber());
}