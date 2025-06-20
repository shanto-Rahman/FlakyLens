@Test public void testGetPathParameter(){
assertEquals(null,context.getPathParameter("parameter_not_set"));
assertEquals("parameter",context.getPathParameter("parameter"));
}