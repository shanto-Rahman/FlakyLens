@Test public void defaultExpirationDateFullyCachedForMoreThan24Hours() throws Exception {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals("A",readAscii(connection));
assertEquals("113 HttpURLConnection \"Heuristic expiration\"",connection.getHeaderField("Warning"));
}