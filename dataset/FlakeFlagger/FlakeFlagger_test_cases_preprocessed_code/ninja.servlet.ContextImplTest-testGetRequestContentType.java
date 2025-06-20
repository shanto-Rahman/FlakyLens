@Test public void testGetRequestContentType(){
assertEquals(contentType,context.getRequestContentType());
assertNull(context.getRequestContentType());
assertEquals(contentType,context.getRequestContentType());
}