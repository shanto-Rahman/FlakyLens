@Test public void testPutValuesAsJson(){
assertEquals("PUT",jsonHttpTestTest.getResponse().getMethod());
assertEquals("PUT",req1.getMethod());
assertEquals("{\"G\":\"g\",\"S\":\"s\"}",req1.getRequest());
}