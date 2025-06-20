@Test public void etagAndExpirationDateInThePast() throws Exception {
assertTrue(headers.contains("If-None-Match: v1"));
assertTrue(headers.contains("If-Modified-Since: " + lastModifiedDate));
}