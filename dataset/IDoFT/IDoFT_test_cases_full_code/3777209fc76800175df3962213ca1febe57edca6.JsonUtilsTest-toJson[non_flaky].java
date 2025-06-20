@Test public void toJson(){
  List<String> testList=new LinkedList<>();
  Map<String,String> testMap=new HashMap<>();
  for (int i=0; i < 10; i++) {
    testList.add("test_string_" + i);
    testMap.put("test_map_" + i,"test_value_" + i);
  }
  TestObject object=TestObject.builder().id(123).name("test object").deleted(false).testList(testList).testMap(testMap).nullObject(null).emptyList(new LinkedList<>()).emptyMap(new HashMap<>()).nestedMap(new HashMap<String,Object>(){
{
      put("map1",testMap);
      put("map2",new HashMap<>());
      put("boolean",false);
      put("testInt",100);
      put("class","nestedClass");
    }
  }
).build();
  JsonParser parser=new JsonParser();
  JsonElement expectedJson=parser.parse(EXPECTED_JSON);
  JsonElement objectJson=parser.parse(JsonUtils.toJson(object));
  assertEquals(expectedJson,objectJson);
  Object o=new Object();
  assertEquals(Constants.EMPTY_JSON,JsonUtils.toJson(o));
}
