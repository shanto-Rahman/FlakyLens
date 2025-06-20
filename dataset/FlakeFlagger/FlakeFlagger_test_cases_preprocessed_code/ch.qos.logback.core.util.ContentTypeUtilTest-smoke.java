@Test public void smoke(){
assertTrue(ContentTypeUtil.isTextual(contextType));
assertEquals("html",ContentTypeUtil.getSubType(contextType));
}