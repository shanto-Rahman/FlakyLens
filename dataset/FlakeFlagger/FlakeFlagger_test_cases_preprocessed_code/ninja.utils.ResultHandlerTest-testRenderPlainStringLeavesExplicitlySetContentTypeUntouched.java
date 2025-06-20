@Test public void testRenderPlainStringLeavesExplicitlySetContentTypeUntouched(){
assertEquals(contentType,result.getContentType());
}