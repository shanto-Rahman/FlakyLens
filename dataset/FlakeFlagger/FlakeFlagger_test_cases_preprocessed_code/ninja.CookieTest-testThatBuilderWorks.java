@Test public void testThatBuilderWorks(){
assertEquals("key",cookie.getName());
assertEquals("value",cookie.getValue());
assertEquals(-1,cookie.getMaxAge());
assertEquals("/",cookie.getPath());
}