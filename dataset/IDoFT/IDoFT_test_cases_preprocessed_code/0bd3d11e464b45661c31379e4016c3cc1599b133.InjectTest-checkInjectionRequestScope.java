@Test @InSequence(5) public void checkInjectionRequestScope() throws IOException {
String output=getResponse(indexUrl,client);//RW
assertTrue("Injection of RequestScope pojo failed in page Index",output.contains("request:true"));
output=getResponse(new URL(indexUrl.toString() + "/" + RequestScopePage.class.getSimpleName()),client);//RW
assertTrue("Injection of RequestScope pojo failed in page Index",output.contains("request:false"));
}