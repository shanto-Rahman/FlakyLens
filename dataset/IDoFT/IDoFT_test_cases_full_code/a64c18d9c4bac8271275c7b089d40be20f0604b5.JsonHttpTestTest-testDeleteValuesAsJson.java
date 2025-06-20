@Test public void testDeleteValuesAsJson(){
  JsonHttpTest jsonHttpTestTest=new JsonHttpTest();
  jsonHttpTestTest.setValueFor("3","C");
  jsonHttpTestTest.setValueFor("4","d");
  XmlHttpResponse req1=checkCall(url -> jsonHttpTestTest.deleteWithValuesAsJson(url));
  assertEquals("DELETE",jsonHttpTestTest.getResponse().getMethod());
  assertEquals("DELETE",req1.getMethod());
  assertEquals("{\"C\":\"3\",\"d\":\"4\"}",req1.getRequest());
}
