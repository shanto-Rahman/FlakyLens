@Test public void testDeleteValuesAsJson(){
assertEquals("DELETE",jsonHttpTestTest.getResponse().getMethod());
assertEquals("DELETE",req1.getMethod());
assertEquals("{\"C\":\"3\",\"d\":\"4\"}",req1.getRequest());
}