@Test public void authenticate() throws Exception {
assertEquals("Successful auth!",readAscii(connection.getInputStream(),Integer.MAX_VALUE));
assertEquals("GET / HTTP/1.1",accepted.getRequestLine());
}