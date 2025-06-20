public void test_for_multimap() throws Exception {
  HashMultimap map=HashMultimap.create();
  map.put("name","a");
  map.put("name","b");
  String json=JSON.toJSONString(map);
  assertTrue(json.equals("{\"name\":[\"a\",\"b\"]}") || json.equals("{\"name\":[\"b\",\"a\"]}"));
}
