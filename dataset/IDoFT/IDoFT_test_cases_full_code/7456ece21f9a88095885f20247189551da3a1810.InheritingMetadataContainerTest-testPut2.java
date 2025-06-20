@Test public void testPut2(){
  MetadataKey key1=new FieldMetadataKey("s",1,"sfn","f1");
  MetadataKey key4=new FieldMetadataKey("s",1,"sfn","f1");
  MetadataValue value1=MetadataValue.builder().doc("doc1").attributes(null).updatedAt(new Date()).updatedBy("me").build();
  MetadataValue value4=MetadataValue.builder().doc("doc4").attributes(null).updatedAt(new Date()).updatedBy("me").build();
  InheritingMetadataContainer container=new InheritingMetadataContainer("s");
  MetadataValue old1=container.put(key1,value1);
  MetadataValue old4=container.put(key4,value4);
  Assert.assertNull(old1);
  Assert.assertEquals(old4,value1);
}
