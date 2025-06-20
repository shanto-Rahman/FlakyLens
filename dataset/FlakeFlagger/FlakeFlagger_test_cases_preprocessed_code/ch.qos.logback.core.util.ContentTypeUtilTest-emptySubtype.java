@Test public void emptySubtype(){
assertTrue(ContentTypeUtil.isTextual(contextType));
assertNull(ContentTypeUtil.getSubType(contextType));
}