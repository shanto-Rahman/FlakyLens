public void test_reserve() throws Exception {
  JSONObject object=JSON.parseObject("{\"id\":1001,\"name\":\"ljw\",\"age\":50}");
  assertEquals("[1001,\"ljw\"]",JSONPath.reserveToArray(object,"id","name").toString());
  assertEquals("[\"ljw\",1001]",JSONPath.reserveToArray(object,"name","id").toString());
  assertEquals("[\"ljw\",[\"ljw\",1001,50]]",JSONPath.reserveToArray(object,"name","*").toString());
}
