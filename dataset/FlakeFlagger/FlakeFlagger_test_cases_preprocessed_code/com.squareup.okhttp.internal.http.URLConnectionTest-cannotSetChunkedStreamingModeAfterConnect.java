@Test public void cannotSetChunkedStreamingModeAfterConnect() throws Exception {
assertEquals("A",readAscii(connection.getInputStream(),Integer.MAX_VALUE));
fail();
}