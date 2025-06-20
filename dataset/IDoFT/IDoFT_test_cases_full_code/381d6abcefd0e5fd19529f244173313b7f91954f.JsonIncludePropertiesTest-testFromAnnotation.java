public void testFromAnnotation(){
  JsonIncludeProperties.Value v=JsonIncludeProperties.Value.from(Bogus.class.getAnnotation(JsonIncludeProperties.class));
  assertNotNull(v);
  Set<String> included=v.getIncluded();
  assertEquals(2,v.getIncluded().size());
  assertEquals(_set("foo","bar"),included);
  assertEquals("JsonIncludeProperties.Value(included=[bar, foo])",v.toString());
  assertEquals(v,JsonIncludeProperties.Value.from(Bogus.class.getAnnotation(JsonIncludeProperties.class)));
}
