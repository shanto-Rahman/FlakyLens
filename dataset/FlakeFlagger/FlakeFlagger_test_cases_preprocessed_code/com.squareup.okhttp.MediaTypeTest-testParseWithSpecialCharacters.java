@Test public void testParseWithSpecialCharacters() throws Exception {
assertEquals("!#$%&'*+-.{|}~",mediaType.type());
assertEquals("!#$%&'*+-.{|}~",mediaType.subtype());
}