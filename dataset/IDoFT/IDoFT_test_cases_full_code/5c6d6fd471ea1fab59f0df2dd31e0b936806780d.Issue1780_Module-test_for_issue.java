public void test_for_issue(){
  org.json.JSONObject req=new org.json.JSONObject();
  SerializeConfig config=new SerializeConfig();
  config.register(new myModule());
  req.put("id",1111);
  req.put("name","name11");
  Assert.assertEquals("{\"name\":\"name11\",\"id\":1111}",JSON.toJSONString(req,config));
}
