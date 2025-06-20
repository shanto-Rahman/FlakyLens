public void testDefaultShapeOverride() throws Exception {
  ObjectMapper mapper=jsonMapperBuilder().withConfigOverride(Map.Entry.class,o -> o.setFormat(JsonFormat.Value.forShape(JsonFormat.Shape.POJO))).configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY,true).build();
  Map.Entry<String,String> input=new BeanWithMapEntry("foo","bar").entry;
  assertEquals(aposToQuotes("{'key':'foo','value':'bar'}"),mapper.writeValueAsString(input));
}
