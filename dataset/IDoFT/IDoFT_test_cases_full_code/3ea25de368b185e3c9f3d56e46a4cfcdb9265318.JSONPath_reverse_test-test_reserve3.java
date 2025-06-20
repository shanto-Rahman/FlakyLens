public void test_reserve3() throws Exception {
  JSONObject object=JSON.parseObject("{\"player\":{\"id\":1001,\"name\":\"ljw\",\"age\":50}}");
  assertEquals("{\"player\":{\"name\":\"ljw\",\"id\":1001}}",JSONPath.reserveToObject(object,"player.id","player.name").toString());
  assertEquals("{\"player\":{\"name\":\"ljw\",\"id\":1001}}",JSONPath.reserveToObject(object,"player.name","player.id","ab.c").toString());
}
