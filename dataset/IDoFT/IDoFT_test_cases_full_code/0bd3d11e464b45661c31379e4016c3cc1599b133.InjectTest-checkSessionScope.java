@Test @InSequence(1) public void checkSessionScope() throws IOException {
  HttpClient client=new HttpClient();
  String output=getResponse(new URL(indexUrl.toString() + "/" + SessionScopePage.class.getSimpleName()),client);
  assertTrue("Injection of SessionScope pojo failed in page Index 1",output.contains("session:true"));
  output=getResponse(indexUrl,client);
  assertTrue("Injection of SessionScope pojo failed in page Index 2",output.contains("session:true"));
  output=getResponse(new URL(indexUrl.toString() + "/" + InvalidateSessionPage.class.getSimpleName()),client);
  assertNotNull(output);
  output=getResponse(indexUrl,client);
  assertTrue("Injection of SessionScope pojo failed in page Index 3",output.contains("session:false"));
}
