public void test_0() throws Exception {
  JSONSerializer serializer=new JSONSerializer();
  serializer.getMapping().clearSerializers();
  int size=JSONSerializerMapTest.size(serializer.getMapping());
  serializer.config(SerializerFeature.WriteEnumUsingToString,false);
  serializer.config(SerializerFeature.WriteEnumUsingName,false);
  serializer.write(Type.A);
  Assert.assertTrue(size < JSONSerializerMapTest.size(serializer.getMapping()));
  Assert.assertEquals(Integer.toString(Type.A.ordinal()),serializer.getWriter().toString());
}
