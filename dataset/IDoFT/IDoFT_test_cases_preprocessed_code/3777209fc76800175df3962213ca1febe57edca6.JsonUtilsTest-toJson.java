@Test public void toJson(){
TestObject object=TestObject.builder().id(123).name("test object").deleted(false).testList(testList).testMap(testMap).nullObject(null).emptyList(new LinkedList<>()).emptyMap(new HashMap<>()).nestedMap(new HashMap<String,Object>(){
{
    put("map1",testMap);
    put("map2",new HashMap<>());
    put("boolean",false);
    put("testInt",100);
    put("class","nestedClass");
  }
}
).build();//IT
assertEquals(EXPECTED_JSON,JsonUtils.toJson(object));
assertEquals("{}",JsonUtils.toJson(o));
}