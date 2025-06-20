@Test public void testPut3(){
  MetadataKey key11=new FieldMetadataKey("s",1,"sfn","f1");
  MetadataKey key12=new FieldMetadataKey("s",1,"sfn","f2");
  MetadataKey key51=new FieldMetadataKey("s",5,"sfn","f1");
  MetadataValue value11=MetadataValue.builder().doc("doc11").attributes(null).updatedAt(new Date()).updatedBy("me").build();
  MetadataValue value121=MetadataValue.builder().doc("doc121").attributes(null).updatedAt(new Date()).updatedBy("me").build();
  MetadataValue value122=MetadataValue.builder().doc("doc122").attributes(null).updatedAt(new Date()).updatedBy("me").build();
  MetadataValue value51=MetadataValue.builder().doc("doc51").attributes(null).updatedAt(new Date()).updatedBy("me").build();
  InheritingMetadataContainer container=new InheritingMetadataContainer("s");
  container.put(key11,value11);
  container.put(key51,value51);
  container.put(key12,value121);
  container.put(key12,value122);
  List<MetadataValue> target=container.getCollection(6).entrySet().stream().filter(e -> e.getKey().getType() == MetadataType.FIELD && ((FieldMetadataKey)e.getKey()).getField().equals("f2")).map(Map.Entry::getValue).collect(Collectors.toList());
  Assert.assertEquals(target.size(),1);
  Assert.assertEquals(target.get(0),value122);
}
