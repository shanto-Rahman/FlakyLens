@Test public void connectionIsReturnedToPoolAfterConditionalSuccess() throws Exception {
assertEquals("A",readAscii(openConnection(server.getUrl("/a"))));
assertEquals("A",readAscii(openConnection(server.getUrl("/a"))));
assertEquals("B",readAscii(openConnection(server.getUrl("/b"))));
assertEquals(0,server.takeRequest().getSequenceNumber());
assertEquals(1,server.takeRequest().getSequenceNumber());
assertEquals(2,server.takeRequest().getSequenceNumber());
}