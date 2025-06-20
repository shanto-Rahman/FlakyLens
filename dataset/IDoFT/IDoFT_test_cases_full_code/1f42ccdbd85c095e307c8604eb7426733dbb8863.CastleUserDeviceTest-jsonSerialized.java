@Test public void jsonSerialized(){
  CastleUserDevice device=new CastleUserDevice();
  String payloadJson=model.getGson().toJson(device);
  Assertions.assertThat(payloadJson).isEqualTo("{\"risk\":0.0,\"is_current_device\":false}");
}
