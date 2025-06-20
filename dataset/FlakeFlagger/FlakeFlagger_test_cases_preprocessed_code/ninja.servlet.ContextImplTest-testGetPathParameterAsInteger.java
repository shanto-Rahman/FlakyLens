@Test public void testGetPathParameterAsInteger(){
assertEquals(null,context.getPathParameterAsInteger("parameter"));
assertEquals(new Integer(1),context.getPathParameterAsInteger("parameter"));
}