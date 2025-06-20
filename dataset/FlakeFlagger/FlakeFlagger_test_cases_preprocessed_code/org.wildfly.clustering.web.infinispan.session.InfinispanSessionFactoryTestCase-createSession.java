@Test public void createSession(){
assertSame(id,result.getId());
assertSame(metaData,result.getMetaData());
assertSame(attributes,result.getAttributes());
assertSame(localContext,result.getLocalContext());
}