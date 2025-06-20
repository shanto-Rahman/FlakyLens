@Test public void processValidModel() throws IOException {
if (HttpHeader.ETAG.toString().equals(arguments[0])) {
Assert.assertTrue(etagHeaderValue.matches("\".*?\""));
}
}