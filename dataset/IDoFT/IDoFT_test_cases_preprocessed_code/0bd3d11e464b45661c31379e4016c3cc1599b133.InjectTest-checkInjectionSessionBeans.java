@Test @InSequence(4) public void checkInjectionSessionBeans() throws IOException {
String output=getResponse(indexUrl);//RW
assertTrue("Injection of Stateless Session Bean failed in page Index",output.contains("Hello Stateless EJB"));
output=getResponse(new URL(indexUrl.toString() + "/" + StatefulPage.class.getSimpleName()),client);//RW
assertTrue("Injection of Stateful Session Bean failed in page MyStateful\n" + output,output.contains("011stateful"));
output=getResponse(new URL(indexUrl.toString() + "/" + StatefulPage.class.getSimpleName()),client);//RW
assertTrue("Injection of Stateful Session Bean failed in page MyStateful\n" + output,output.contains("122stateful"));
}