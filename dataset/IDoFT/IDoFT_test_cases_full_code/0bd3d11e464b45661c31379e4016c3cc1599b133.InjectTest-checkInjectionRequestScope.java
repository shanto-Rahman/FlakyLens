@Test @InSequence(5) public void checkInjectionRequestScope() throws IOException {
  HttpClient client=new HttpClient();
  String output=getResponse(indexUrl,client);
  assertTrue("Injection of RequestScope pojo failed in page Index",output.contains("request:true"));
  output=getResponse(new URL(indexUrl.toString() + "/" + RequestScopePage.class.getSimpleName()),client);
  assertTrue("Injection of RequestScope pojo failed in page Index",output.contains("request:false"));
}
