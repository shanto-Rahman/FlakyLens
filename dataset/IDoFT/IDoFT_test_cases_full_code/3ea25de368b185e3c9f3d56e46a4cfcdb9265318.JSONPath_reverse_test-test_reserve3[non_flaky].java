public void test_reserve3() throws Exception {
  JSONObject object=JSON.parseObject("{\"player\":{\"id\":1001,\"name\":\"ljw\",\"age\":50}}");
  String text=JSON.toJSONString(JSONPath.reserveToObject(object,"player.id","player.name"),SerializerFeature.MapSortField);
  assertEquals("{\"player\":{\"id\":1001,\"name\":\"ljw\"}}",text);
  text=JSON.toJSONString(JSONPath.reserveToObject(object,"player.name","player.id","ab.c"),SerializerFeature.MapSortField);
  assertEquals("{\"player\":{\"id\":1001,\"name\":\"ljw\"}}",text);
}
