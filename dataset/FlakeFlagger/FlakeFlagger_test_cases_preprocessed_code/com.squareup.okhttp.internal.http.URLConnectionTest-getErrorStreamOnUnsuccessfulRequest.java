@Test public void getErrorStreamOnUnsuccessfulRequest() throws Exception {
assertEquals("A",readAscii(connection.getErrorStream(),Integer.MAX_VALUE));
}