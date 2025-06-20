public void testSimpleEquals() throws Exception {
  ObjectMapper mapper=jsonMapperBuilder().enable(SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID).configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY,true).build();
  Foo foo=new Foo(1);
  Bar bar1=new Bar(1);
  Bar bar2=new Bar(2);
  Bar anotherBar1=new Bar(1);
  foo.bars.add(bar1);
  foo.bars.add(bar2);
  foo.otherBars.add(anotherBar1);
  foo.otherBars.add(bar2);
  String json=mapper.writeValueAsString(foo);
  assertEquals("{\"id\":1,\"bars\":[{\"id\":1},{\"id\":2}],\"otherBars\":[1,2]}",json);
  Foo foo2=mapper.readValue(json,Foo.class);
  assertNotNull(foo2);
  assertEquals(foo.id,foo2.id);
}
