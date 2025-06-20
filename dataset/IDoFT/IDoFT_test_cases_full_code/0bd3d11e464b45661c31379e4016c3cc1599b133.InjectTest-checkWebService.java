@Test @InSequence(10) public void checkWebService() throws IOException {
  String output=getResponse(new URL(indexUrl.toString() + "/" + WSPage.class.getSimpleName()));
  assertNotNull(output);
  assertTrue("Injection of webservice failed in page WSPage",output.contains("Hello John"));
}
