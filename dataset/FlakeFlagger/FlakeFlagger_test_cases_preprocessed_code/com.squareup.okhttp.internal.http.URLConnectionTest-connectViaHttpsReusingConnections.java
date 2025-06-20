@Test public void connectViaHttpsReusingConnections() throws IOException, InterruptedException {
assertEquals(0,server.takeRequest().getSequenceNumber());
assertEquals(1,server.takeRequest().getSequenceNumber());
}