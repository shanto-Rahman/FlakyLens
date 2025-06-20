public void test_for_issue(){
  org.json.JSONObject req=new org.json.JSONObject();
  SerializeConfig config=new SerializeConfig();
  config.register(new myModule());
  req.put("id",1111);
  req.put("name","name11");
  String text=JSON.toJSONString(req,SerializerFeature.SortField);
  Assert.assertEquals("{\"id\":1111,\"name\":\"name11\"}",text);
}
