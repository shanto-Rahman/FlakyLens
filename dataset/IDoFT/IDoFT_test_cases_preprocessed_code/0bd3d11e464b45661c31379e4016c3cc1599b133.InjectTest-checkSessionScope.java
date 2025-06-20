@Test @InSequence(1) public void checkSessionScope() throws IOException {
String output=getResponse(new URL(indexUrl.toString() + "/" + SessionScopePage.class.getSimpleName()),client);//RW
assertTrue("Injection of SessionScope pojo failed in page Index 1",output.contains("session:true"));
output=getResponse(indexUrl,client);//RW
assertTrue("Injection of SessionScope pojo failed in page Index 2",output.contains("session:true"));
output=getResponse(new URL(indexUrl.toString() + "/" + InvalidateSessionPage.class.getSimpleName()),client);//RW
assertNotNull(output);
output=getResponse(indexUrl,client);//RW
assertTrue("Injection of SessionScope pojo failed in page Index 3",output.contains("session:false"));
}