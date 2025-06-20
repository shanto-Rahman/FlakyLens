@Test public void testGetPathParameterDecodingWorks(){
assertEquals("blue/red?and+green€/",context.getPathParameter("parameter"));
}