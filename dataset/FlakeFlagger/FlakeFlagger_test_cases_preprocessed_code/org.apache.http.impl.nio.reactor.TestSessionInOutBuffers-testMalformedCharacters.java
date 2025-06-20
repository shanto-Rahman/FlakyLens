@Test public void testMalformedCharacters() throws Exception {
Assert.fail("Expected CharacterCodingException");
Assert.fail("Expected CharacterCodingException, got '" + s + "'");
}