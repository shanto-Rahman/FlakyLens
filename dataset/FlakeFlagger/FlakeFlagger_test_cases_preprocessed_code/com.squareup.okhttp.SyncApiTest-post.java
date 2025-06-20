@Test public void post() throws Exception {
assertEquals("def",recordedRequest.getUtf8Body());
assertEquals("3",recordedRequest.getHeader("Content-Length"));
assertEquals("text/plain; charset=utf-8",recordedRequest.getHeader("Content-Type"));
}