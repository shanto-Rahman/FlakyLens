@Test public void createImmutableSession(){
assertSame(id,result.getId());
assertSame(metaData,result.getMetaData());
assertSame(attributes,result.getAttributes());
}