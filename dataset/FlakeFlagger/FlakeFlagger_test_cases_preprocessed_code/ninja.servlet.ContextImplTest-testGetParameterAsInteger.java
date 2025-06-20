@Test public void testGetParameterAsInteger(){
assertEquals(null,context.getParameterAsInteger("key_not_there"));
assertEquals(new Integer(100),context.getParameterAsInteger("key_not_there",100));
assertEquals(new Integer(1),context.getParameterAsInteger("key"));
}