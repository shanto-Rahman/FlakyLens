@Test public void testFormat() throws Exception {
assertEquals("abc   Hello",result);
assertEquals("abc Hello  ",result);
assertEquals("abc llo",result);
assertEquals("abc Hel",result);
assertEquals("abc  123",result);
assertEquals("abc 123 ",result);
assertEquals("abc ello",result);
assertEquals("abc Hell",result);
}