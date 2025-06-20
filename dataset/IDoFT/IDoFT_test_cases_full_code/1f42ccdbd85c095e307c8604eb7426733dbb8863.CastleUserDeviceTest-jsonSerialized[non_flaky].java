@Test public void jsonSerialized(){
  CastleUserDevice device=new CastleUserDevice();
  String payloadJson=model.getGson().toJson(device);
  JsonParser parser=new JsonParser();
  String expected="{\"risk\":0.0,\"is_current_device\":false}";
  Assert.assertEquals(parser.parse(payloadJson),parser.parse(expected));
}
