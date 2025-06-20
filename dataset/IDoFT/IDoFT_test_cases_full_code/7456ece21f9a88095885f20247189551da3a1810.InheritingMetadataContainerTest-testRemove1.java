@Test public void testRemove1(){
  MetadataKey key1=new FieldMetadataKey("s",1,"sfn","f1");
  MetadataKey key4=new FieldMetadataKey("s",4,"sfn","f1");
  MetadataValue value1=MetadataValue.builder().doc("doc1").attributes(null).updatedAt(new Date()).updatedBy("me").build();
  MetadataValue value4=MetadataValue.builder().doc("doc4").attributes(null).updatedAt(new Date()).updatedBy("me").build();
  InheritingMetadataContainer container=new InheritingMetadataContainer("s");
  container.put(key1,value1);
  container.put(key4,value4);
  MetadataValue old1=container.remove(key1);
  Assert.assertEquals(old1,value1);
  Map<MetadataKey,MetadataValue> byVersion5=container.getCollection(5);
  Assert.assertTrue(byVersion5.size() == 1);
  Assert.assertEquals(byVersion5.get(key4),value4);
  Map<MetadataKey,MetadataValue> byVersion1=container.getCollection(1);
  Assert.assertNull(byVersion1);
}
