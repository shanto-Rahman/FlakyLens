public void test_reserve() throws Exception {
  JSONObject object=JSON.parseObject("{\"id\":1001,\"name\":\"ljw\",\"age\":50}");
  assertEquals("[1001,\"ljw\"]",JSONPath.reserveToArray(object,"id","name").toString());
  assertEquals("[\"ljw\",1001]",JSONPath.reserveToArray(object,"name","id").toString());
  String text=JSON.toJSONString(JSONPath.reserveToArray(object,"name","*"),SerializerFeature.MapSortField);
  assertTrue(text.equals("[\"ljw\",[\"ljw\",1001,50]]") || text.equals("[\"ljw\",[\"ljw\",50,1001]]") || text.equals("[\"ljw\",[50,1001,\"ljw\"]]")|| text.equals("[\"ljw\",[1001,50,\"ljw\"]]")|| text.equals("[\"ljw\",[1001,\"ljw\",50]]")|| text.equals("[\"ljw\",[50,\"ljw\",1001]]"));
}
