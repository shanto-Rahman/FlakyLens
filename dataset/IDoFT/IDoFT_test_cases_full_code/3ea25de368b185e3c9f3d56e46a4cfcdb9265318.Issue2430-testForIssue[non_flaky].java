public void testForIssue(){
  ArrayListMultimap<String,String> multimap=ArrayListMultimap.create();
  multimap.put("a","1");
  multimap.put("a","2");
  multimap.put("a","3");
  multimap.put("b","1");
  VO vo=new VO();
  vo.setMap(multimap);
  vo.setName("zhangsan");
  assertEquals("{\"map\":{\"a\":[\"1\",\"2\",\"3\"],\"b\":[\"1\"]},\"name\":\"zhangsan\"}",JSON.toJSONString(vo,SerializerFeature.MapSortField));
}
