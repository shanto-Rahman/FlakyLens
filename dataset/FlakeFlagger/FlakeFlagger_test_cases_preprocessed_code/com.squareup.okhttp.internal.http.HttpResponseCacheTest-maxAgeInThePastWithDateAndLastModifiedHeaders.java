@Test public void maxAgeInThePastWithDateAndLastModifiedHeaders() throws Exception {
assertTrue(headers.contains("If-Modified-Since: " + lastModifiedDate));
}