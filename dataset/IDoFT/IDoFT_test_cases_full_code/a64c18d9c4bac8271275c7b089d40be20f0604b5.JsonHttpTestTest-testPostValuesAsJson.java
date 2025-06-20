@Test public void testPostValuesAsJson(){
  JsonHttpTest jsonHttpTestTest=new JsonHttpTest();
  jsonHttpTestTest.setValueFor("1","A");
  jsonHttpTestTest.setValueFor("2","B");
  XmlHttpResponse req1=checkCall(url -> jsonHttpTestTest.postValuesAsJsonTo(url));
  assertEquals("POST",jsonHttpTestTest.getResponse().getMethod());
  assertEquals("POST",req1.getMethod());
  assertEquals("{\"A\":\"1\",\"B\":\"2\"}",req1.getRequest());
}
