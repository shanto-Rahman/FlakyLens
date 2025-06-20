@Test public void stringWithDefaultCharsetAdded() throws Exception {
assertEquals(MediaType.parse("text/plain; charset=utf-8"),body.contentType());
assertEquals(3,body.contentLength());
assertEquals("e0a080",bodyToHex(body));
}