@Test public void testLocale() throws Exception {
assertEquals("\"en_US\"",str);
assertEquals(obj,JSON.parse(str,Locale.class));
}