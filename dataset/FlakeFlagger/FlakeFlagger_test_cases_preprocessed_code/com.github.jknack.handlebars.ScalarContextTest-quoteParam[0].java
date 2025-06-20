@Test public void quoteParam() throws IOException {
assertEquals("2\"secs",template.apply(new Object()));
}