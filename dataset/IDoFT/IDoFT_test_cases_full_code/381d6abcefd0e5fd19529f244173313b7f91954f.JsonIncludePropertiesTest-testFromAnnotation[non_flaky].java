public void testFromAnnotation(){
  JsonIncludeProperties.Value v=JsonIncludeProperties.Value.from(Bogus.class.getAnnotation(JsonIncludeProperties.class));
  assertNotNull(v);
  Set<String> included=v.getIncluded();
  assertEquals(2,v.getIncluded().size());
  assertEquals(_set("foo","bar"),included);
  String tmp=v.toString();
  boolean test1=tmp.equals("JsonIncludeProperties.Value(included=[foo, bar])");
  boolean test2=tmp.equals("JsonIncludeProperties.Value(included=[bar, foo])");
  assertTrue(test1 || test2);
  assertEquals(v,JsonIncludeProperties.Value.from(Bogus.class.getAnnotation(JsonIncludeProperties.class)));
}
