@Test public void nullContext(){
assertFalse(ContentTypeUtil.isTextual(contextType));
assertNull(ContentTypeUtil.getSubType(contextType));
}