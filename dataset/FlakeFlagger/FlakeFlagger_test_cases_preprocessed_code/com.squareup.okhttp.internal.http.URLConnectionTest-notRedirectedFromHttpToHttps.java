@Test public void notRedirectedFromHttpToHttps() throws IOException, InterruptedException {
assertEquals("This page has moved!",readAscii(connection.getInputStream(),Integer.MAX_VALUE));
}