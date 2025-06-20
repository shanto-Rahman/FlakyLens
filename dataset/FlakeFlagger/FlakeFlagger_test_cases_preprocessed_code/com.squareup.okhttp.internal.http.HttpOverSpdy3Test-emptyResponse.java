@Test public void emptyResponse() throws IOException {
assertEquals(-1,connection.getInputStream().read());
}