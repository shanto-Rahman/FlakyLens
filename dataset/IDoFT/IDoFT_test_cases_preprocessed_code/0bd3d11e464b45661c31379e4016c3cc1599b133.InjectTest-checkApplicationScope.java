@Test @InSequence(0) public void checkApplicationScope() throws IOException {
String output=getResponse(indexUrl);//RW
assertTrue("Injection of Application Scope Bean failed in page Index",output.contains("Counter : 1"));
output=getResponse(new URL(indexUrl.toString() + "/" + SomePage.class.getSimpleName()));//RW
assertNotNull(output);
output=getResponse(indexUrl);//RW
assertTrue("Injection of Application Scope Bean failed in page Index",output.contains("Counter : 2"));
}