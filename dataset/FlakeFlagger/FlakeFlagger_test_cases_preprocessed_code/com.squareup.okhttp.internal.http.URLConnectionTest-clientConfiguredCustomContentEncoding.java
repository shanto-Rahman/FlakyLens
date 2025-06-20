@Test public void clientConfiguredCustomContentEncoding() throws Exception {
assertEquals("ABCDE",readAscii(connection.getInputStream(),Integer.MAX_VALUE));//ET
}