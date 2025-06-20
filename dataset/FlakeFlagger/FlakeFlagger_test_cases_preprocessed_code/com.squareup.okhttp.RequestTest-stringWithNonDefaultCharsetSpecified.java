@Test public void stringWithNonDefaultCharsetSpecified() throws Exception {
assertEquals(contentType,body.contentType());
assertEquals(2,body.contentLength());
assertEquals("0800",bodyToHex(body));
}