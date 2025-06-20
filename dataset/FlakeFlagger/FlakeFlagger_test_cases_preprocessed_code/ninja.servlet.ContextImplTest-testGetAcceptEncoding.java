@Test public void testGetAcceptEncoding(){
assertEquals(encoding,context.getAcceptEncoding());
assertNull(context.getAcceptEncoding());
assertEquals(encoding,context.getAcceptEncoding());
}