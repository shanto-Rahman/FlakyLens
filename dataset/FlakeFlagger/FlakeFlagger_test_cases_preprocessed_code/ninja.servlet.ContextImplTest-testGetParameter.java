@Test public void testGetParameter(){
assertEquals(null,context.getParameter("key_not_there"));
assertEquals("defaultValue",context.getParameter("key_not_there","defaultValue"));
assertEquals("value",context.getParameter("key"));
}