@Test @InSequence(0) public void checkApplicationScope() throws IOException {
  String output=getResponse(indexUrl);
  assertTrue("Injection of Application Scope Bean failed in page Index",output.contains("Counter : 1"));
  output=getResponse(new URL(indexUrl.toString() + "/" + SomePage.class.getSimpleName()));
  assertNotNull(output);
  output=getResponse(indexUrl);
  assertTrue("Injection of Application Scope Bean failed in page Index",output.contains("Counter : 2"));
}
