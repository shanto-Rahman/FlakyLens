@Test public void put_responseHeadersOk() throws Exception {
assertEquals(200,httpUrlConnection.getResponseCode());
assertEquals("Fantastic",httpUrlConnection.getResponseMessage());
assertEquals(0,urlConnection.getContentLength());
assertEquals(statusLine,httpUrlConnection.getHeaderField(null));
assertEquals("e",httpUrlConnection.getHeaderField("A"));
assertEquals("e",httpUrlConnection.getHeaderField("a"));
assertEquals(Arrays.asList(statusLine),responseHeaders.get(null));
assertEquals(newSet("c","e"),new HashSet<String>(responseHeaders.get("A")));
assertEquals(newSet("c","e"),new HashSet<String>(responseHeaders.get("a")));
fail("Modified an unmodifiable view.");
fail("Modified an unmodifiable view.");
assertEquals(null,httpUrlConnection.getHeaderFieldKey(0));
assertEquals(statusLine,httpUrlConnection.getHeaderField(0));
assertNotNull(httpUrlConnection.getHeaderFieldKey(i));
assertNull(httpUrlConnection.getHeaderFieldKey(i));
}