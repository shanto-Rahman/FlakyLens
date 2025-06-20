@Test public void jsonSerialized(){
  CastleDevice device=new CastleDevice();
  device.setId("d_id");
  device.setName("d_name");
  device.setType("d_type");
  device.setManufacturer("d_manufacturer");
  device.setModel("d_model");
  String payloadJson=model.getGson().toJson(device);
  JsonParser parser=new JsonParser();
  String expected="{\"id\":\"d_id\",\"manufacturer\":\"d_manufacturer\",\"model\":\"d_model\",\"name\":\"d_name\",\"type\":\"d_type\"}";
  Assertions.assertThat(parser.parse(payloadJson)).isEqualTo(parser.parse(expected));
}
