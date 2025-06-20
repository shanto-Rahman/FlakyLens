@Test public void getContexts(){
assertTrue(result.hasNext());
assertSame(this.host,context.getHost());
assertSame(expectedPath,context.getPath());
assertFalse(result.hasNext());
}