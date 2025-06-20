@Test public void testPostValuesAsJson(){
assertEquals("POST",jsonHttpTestTest.getResponse().getMethod());
assertEquals("POST",req1.getMethod());
assertEquals("{\"A\":\"1\",\"B\":\"2\"}",req1.getRequest());
}