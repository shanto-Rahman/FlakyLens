@Test public void testCharsetIsOneOfManyParameters() throws Exception {
assertEquals("text",mediaType.type());
assertEquals("plain",mediaType.subtype());
assertEquals("UTF-8",mediaType.charset().name());
}