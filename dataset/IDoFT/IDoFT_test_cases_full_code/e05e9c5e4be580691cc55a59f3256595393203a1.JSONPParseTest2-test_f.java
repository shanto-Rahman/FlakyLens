public void test_f() throws Exception {
  String text="parent.callback ({'id':1, 'name':'idonans'} );   /**/ ";
  JSONPObject jsonpObject=JSON.parseObject(text,JSONPObject.class);
  assertEquals("parent.callback",jsonpObject.getFunction());
  assertEquals(1,jsonpObject.getParameters().size());
  JSONObject param=(JSONObject)jsonpObject.getParameters().get(0);
  assertEquals(1,param.get("id"));
  assertEquals("idonans",param.get("name"));
  String json=JSON.toJSONString(jsonpObject);
  assertEquals("parent.callback({\"name\":\"idonans\",\"id\":1})",json);
}
