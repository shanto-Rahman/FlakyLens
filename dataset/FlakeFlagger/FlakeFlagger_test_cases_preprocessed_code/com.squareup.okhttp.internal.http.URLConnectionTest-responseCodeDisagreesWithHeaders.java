@Test public void responseCodeDisagreesWithHeaders() throws IOException, InterruptedException {
assertEquals("This body is not allowed!",readAscii(connection.getInputStream(),Integer.MAX_VALUE));
}