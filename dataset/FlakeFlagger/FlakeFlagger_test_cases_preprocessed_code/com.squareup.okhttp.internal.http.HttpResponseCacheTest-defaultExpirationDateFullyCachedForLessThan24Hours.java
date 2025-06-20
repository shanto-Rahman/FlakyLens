@Test public void defaultExpirationDateFullyCachedForLessThan24Hours() throws Exception {
assertEquals("A",readAscii(openConnection(url)));
assertEquals("A",readAscii(connection));
assertNull(connection.getHeaderField("Warning"));
}