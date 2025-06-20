@Test public void requestMaxStale() throws IOException {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals("A",readAscii(connection));
assertEquals("110 HttpURLConnection \"Response is stale\"",connection.getHeaderField("Warning"));
}