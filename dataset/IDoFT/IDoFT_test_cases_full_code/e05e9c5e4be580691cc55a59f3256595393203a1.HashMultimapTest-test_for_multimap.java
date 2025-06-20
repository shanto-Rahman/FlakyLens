public void test_for_multimap() throws Exception {
  HashMultimap map=HashMultimap.create();
  map.put("name","a");
  map.put("name","b");
  String json=JSON.toJSONString(map);
  assertEquals("{\"name\":[\"a\",\"b\"]}",json);
}
