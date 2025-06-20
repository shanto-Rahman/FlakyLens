@Test public void testDefaultCharset() throws Exception {
assertEquals("UTF-8",noCharset.charset(Util.UTF_8).name());
assertEquals("US-ASCII",noCharset.charset(Charset.forName("US-ASCII")).name());
assertEquals("ISO-8859-1",charset.charset(Util.UTF_8).name());
assertEquals("ISO-8859-1",charset.charset(Charset.forName("US-ASCII")).name());
}