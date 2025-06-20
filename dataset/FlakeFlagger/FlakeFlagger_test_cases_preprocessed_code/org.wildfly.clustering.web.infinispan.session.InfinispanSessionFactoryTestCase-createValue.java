@Test public void createValue(){
assertNotNull(result);
assertSame(metaData,result.getKey());
assertSame(attributes,result.getValue());
}