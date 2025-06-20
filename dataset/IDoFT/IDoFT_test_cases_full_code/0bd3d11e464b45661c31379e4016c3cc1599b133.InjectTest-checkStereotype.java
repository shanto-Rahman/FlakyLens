@Test @InSequence(11) public void checkStereotype() throws IOException {
  HttpClient client=new HttpClient();
  String output=getResponse(new URL(indexUrl.toString() + "/" + StereotypePage.class.getSimpleName()),client);
  assertNotNull(output);
  assertTrue("Injection of stereotyped bean failed in page StereotypePage",output.contains("Stereotype bean:true"));
  assertTrue("Stereotype Bean not SessionScoped as expected in page StereotypePage",output.contains("Same instance:true"));
  output=getResponse(indexUrl,client);
  output=getResponse(new URL(indexUrl.toString() + "/" + InvalidateSessionPage.class.getSimpleName()),client);
  assertNotNull(output);
  output=getResponse(indexUrl,client);
  assertTrue("Stereotype Bean not SessionScoped as expected in page StereotypePage",output.contains("stereotype:false"));
}
