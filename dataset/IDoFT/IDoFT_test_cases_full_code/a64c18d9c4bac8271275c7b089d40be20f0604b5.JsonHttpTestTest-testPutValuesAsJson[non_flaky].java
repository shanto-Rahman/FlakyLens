@Test public void testPutValuesAsJson(){
  JsonHttpTest jsonHttpTestTest=new JsonHttpTest();
  jsonHttpTestTest.setValueFor("g","G");
  jsonHttpTestTest.setValueFor("s","S");
  XmlHttpResponse req1=checkCall(url -> jsonHttpTestTest.putValuesAsJsonTo(url));
  assertEquals("PUT",jsonHttpTestTest.getResponse().getMethod());
  assertEquals("PUT",req1.getMethod());
  assertEquals("{\"G\":\"g\",\"S\":\"s\"}",req1.getRequest());
}
