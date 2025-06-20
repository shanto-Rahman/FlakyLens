@Test public void cannotSetFixedLengthStreamingModeAfterConnect() throws Exception {
assertEquals("A",readAscii(connection.getInputStream(),Integer.MAX_VALUE));
fail();
}