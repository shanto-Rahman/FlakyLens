public void test_for_issue() throws Exception {
  String text="{\"a\":{\"x\":\"y\"},\"b\":{\"x\":\"y\"}}";
  JSONObject jsonObject=JSONObject.parseObject(text);
  System.out.println(jsonObject);
  String jsonpath="$..x";
  String value="y2";
  JSONPath.set(jsonObject,jsonpath,value);
  assertEquals("{\"a\":{\"x\":\"y2\"},\"b\":{\"x\":\"y2\"}}",JSON.toJSONString(jsonObject,SerializerFeature.MapSortField));
}
