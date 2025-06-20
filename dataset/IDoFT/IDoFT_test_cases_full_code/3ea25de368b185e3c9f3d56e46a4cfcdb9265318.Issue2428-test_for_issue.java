public void test_for_issue(){
  Issue2428 demoBean=new Issue2428();
  demoBean.setMyName("test name");
  demoBean.setNestedBean(new NestedBean("test id"));
  assertEquals("{\"nestedBean\":{\"myId\":\"test id\"},\"myName\":\"test name\"}",JSON.toJSON(demoBean).toString());
  SerializeConfig serializeConfig=new SerializeConfig();
  serializeConfig.propertyNamingStrategy=PropertyNamingStrategy.SnakeCase;
  assertEquals("{\"my_name\":\"test name\",\"nested_bean\":{\"my_id\":\"test id\"}}",JSON.toJSON(demoBean,serializeConfig).toString());
}
