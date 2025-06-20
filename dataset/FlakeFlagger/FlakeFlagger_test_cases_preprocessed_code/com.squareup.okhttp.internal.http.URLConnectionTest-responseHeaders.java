@Test public void responseHeaders() throws IOException, InterruptedException {
assertEquals(200,connection.getResponseCode());
assertEquals("Fantastic",connection.getResponseMessage());
assertEquals("HTTP/1.0 200 Fantastic",connection.getHeaderField(null));
Map<String,List<String>> responseHeaders=connection.getHeaderFields();//ET
assertEquals(Arrays.asList("HTTP/1.0 200 Fantastic"),responseHeaders.get(null));
assertEquals(newSet("c","e"),new HashSet<String>(responseHeaders.get("A")));
assertEquals(newSet("c","e"),new HashSet<String>(responseHeaders.get("a")));
fail("Modified an unmodifiable view.");
fail("Modified an unmodifiable view.");
assertEquals("A",connection.getHeaderFieldKey(0));
assertEquals("c",connection.getHeaderField(0));
assertEquals("B",connection.getHeaderFieldKey(1));
assertEquals("d",connection.getHeaderField(1));
assertEquals("A",connection.getHeaderFieldKey(2));
assertEquals("e",connection.getHeaderField(2));
}