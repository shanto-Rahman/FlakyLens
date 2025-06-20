public void testToStringImplWithNullValues() throws Exception {
  Map<String,String> hashmap=Maps.newHashMap();
  hashmap.put("foo","bar");
  hashmap.put("baz",null);
  assertEquals(hashmap.toString(),Maps.toStringImpl(hashmap));
}
