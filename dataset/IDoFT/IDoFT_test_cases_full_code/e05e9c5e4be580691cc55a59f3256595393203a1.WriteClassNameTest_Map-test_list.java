public void test_list() throws Exception {
  Model model=new Model();
  Map tables=new LinkedHashMap();
  tables.put("1001",new ExtTable(1001));
  tables.put("1002",new Table());
  model.setTables(tables);
  String json=JSON.toJSONString(model);
  assertEquals("{\"tables\":{\"1001\":{\"@type\":\"com.alibaba.json.bvt.writeClassName.WriteClassNameTest_Map$ExtTable\",\"id\":1001},\"1002\":{}}}",json);
  JSONObject jsonObject=JSON.parseObject(json,Feature.IgnoreAutoType);
  assertEquals("{\"tables\":{\"1002\":{},\"1001\":{\"id\":1001}}}",jsonObject.toJSONString());
  Model model2=JSON.parseObject(json,Model.class);
  assertEquals(ExtTable.class,model2.getTables().get("1001").getClass());
}
