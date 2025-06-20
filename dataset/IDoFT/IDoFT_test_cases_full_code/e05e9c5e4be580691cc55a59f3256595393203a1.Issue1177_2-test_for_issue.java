public void test_for_issue() throws Exception {
  String text="{\"a\":{\"x\":\"y\"},\"b\":{\"x\":\"y\"}}";
  Map<String,Model> jsonObject=JSONObject.parseObject(text,new TypeReference<Map<String,Model>>(){
  }
);
  System.out.println(JSON.toJSONString(jsonObject));
  String jsonpath="$..x";
  String value="y2";
  JSONPath.set(jsonObject,jsonpath,value);
  assertEquals("{\"a\":{\"x\":\"y2\"},\"b\":{\"x\":\"y2\"}}",JSON.toJSONString(jsonObject));
}
