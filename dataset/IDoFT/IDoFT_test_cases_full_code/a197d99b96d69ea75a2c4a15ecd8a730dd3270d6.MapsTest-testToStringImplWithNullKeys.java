public void testToStringImplWithNullKeys() throws Exception {
  Map<String,String> hashmap=Maps.newHashMap();
  hashmap.put("foo","bar");
  hashmap.put(null,"baz");
  assertEquals(hashmap.toString(),Maps.toStringImpl(hashmap));
}
