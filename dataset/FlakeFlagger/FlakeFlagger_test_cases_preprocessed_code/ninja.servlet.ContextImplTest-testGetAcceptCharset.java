@Test public void testGetAcceptCharset(){
assertEquals(charset,context.getAcceptCharset());
assertNull(context.getAcceptCharset());
assertEquals(charset,context.getAcceptCharset());
}