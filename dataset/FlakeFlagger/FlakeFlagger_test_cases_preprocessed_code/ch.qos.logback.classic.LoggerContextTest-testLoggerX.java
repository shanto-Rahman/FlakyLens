@Test public void testLoggerX(){
assertNotNull(x);
assertEquals("x",x.getName());
assertNull(x.getLevel());
assertEquals(Level.DEBUG,x.getEffectiveLevel());
}