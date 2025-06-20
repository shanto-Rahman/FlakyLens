@Test public void testGetAcceptContentType(){
assertEquals(Result.TEXT_HTML,context.getAcceptContentType());
assertEquals(Result.TEXT_HTML,context.getAcceptContentType());
assertEquals(Result.TEXT_HTML,context.getAcceptContentType());
assertEquals(Result.APPLICATON_JSON,context.getAcceptContentType());
assertEquals(Result.TEXT_HTML,context.getAcceptContentType());
assertEquals(Result.TEXT_HTML,context.getAcceptContentType());
assertEquals(Result.TEXT_PLAIN,context.getAcceptContentType());
assertEquals(Result.APPLICATON_JSON,context.getAcceptContentType());
}