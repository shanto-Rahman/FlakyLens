@Test public void testJSONMap(){
  Map<Object,Object> map=new LinkedHashMap<>();
  map.put(1,"bar");
  map.put("foo",2);
  assertEquals("[\"A\",{\"1\":\"bar\",\"foo\":2},\"B\"]",TextUtils.joinJSON(Arrays.asList("A",map,"B")));
}
