@Test @InSequence(2) public void checkInjectionsPojoFromOutput() throws IOException {
String output=getResponse(indexUrl);//RW
assertTrue("Injection of Pojo failed in page index",output.contains("injected pojo"));
assertTrue("Injection of NamedPojo failed in page index",output.contains("injected named pojo"));
assertTrue("Injection of Pojo failed in component DumbComponent",output.contains("I named pojo into component"));
assertTrue("Injection of NamedPojo failed in component DumbComponent",output.contains("I pojo into component"));
}