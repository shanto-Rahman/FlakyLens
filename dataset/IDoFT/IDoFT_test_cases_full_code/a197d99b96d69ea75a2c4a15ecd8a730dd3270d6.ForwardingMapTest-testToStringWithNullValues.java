public void testToStringWithNullValues() throws Exception {
  Map<String,String> hashmap=Maps.newHashMap();
  hashmap.put("foo","bar");
  hashmap.put("baz",null);
  StandardImplForwardingMap<String,String> forwardingMap=new StandardImplForwardingMap<>(Maps.<String,String>newHashMap());
  forwardingMap.put("foo","bar");
  forwardingMap.put("baz",null);
  assertEquals(hashmap.toString(),forwardingMap.toString());
}
