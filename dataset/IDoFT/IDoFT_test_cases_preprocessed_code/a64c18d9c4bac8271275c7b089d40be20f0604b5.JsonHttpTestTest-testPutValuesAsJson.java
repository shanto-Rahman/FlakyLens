@Test public void testPutValuesAsJson(){
assertEquals("PUT",jsonHttpTestTest.getResponse().getMethod());
assertEquals("PUT",req1.getMethod());
assertEquals("{\"S\":\"s\",\"G\":\"g\"}",req1.getRequest());
}