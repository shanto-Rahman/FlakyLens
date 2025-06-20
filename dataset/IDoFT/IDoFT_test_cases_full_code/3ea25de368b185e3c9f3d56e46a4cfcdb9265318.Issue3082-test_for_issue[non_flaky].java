public void test_for_issue() throws Exception {
  HashSet<Map.Entry<String,Map.Entry<String,String>>> nestedSet=new HashSet<Map.Entry<String,Map.Entry<String,String>>>();
  nestedSet.add(new AbstractMap.SimpleEntry<String,Map.Entry<String,String>>("a",new AbstractMap.SimpleEntry<String,String>("b","c")));
  nestedSet.add(new AbstractMap.SimpleEntry<String,Map.Entry<String,String>>("d",new AbstractMap.SimpleEntry<String,String>("e","f")));
  String content=JSON.toJSONString(nestedSet);
  HashSet<Map.Entry<String,Map.Entry<String,String>>> deserializedNestedSet;
  Type type=new TypeReference<HashSet<Map.Entry<String,Map.Entry<String,String>>>>(){
  }
.getType();
  deserializedNestedSet=JSON.parseObject(content,type);
  assertEquals(nestedSet,deserializedNestedSet);
}
