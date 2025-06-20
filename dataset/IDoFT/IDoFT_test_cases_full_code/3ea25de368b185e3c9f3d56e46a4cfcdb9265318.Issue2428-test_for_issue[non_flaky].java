public void test_for_issue(){
  Issue2428 demoBean=new Issue2428();
  demoBean.setMyName("test name");
  demoBean.setNestedBean(new NestedBean("test id"));
  String text=JSON.toJSONString(JSON.toJSON(demoBean),SerializerFeature.MapSortField);
  assertEquals("{\"myName\":\"test name\",\"nestedBean\":{\"myId\":\"test id\"}}",text);
  SerializeConfig serializeConfig=new SerializeConfig();
  serializeConfig.propertyNamingStrategy=PropertyNamingStrategy.SnakeCase;
  text=JSON.toJSONString(JSON.toJSON(demoBean,serializeConfig),SerializerFeature.MapSortField);
  assertEquals("{\"my_name\":\"test name\",\"nested_bean\":{\"my_id\":\"test id\"}}",text);
}
