@Test public void fullBuilderJson(){
  CastleDevice device=CastleDevice.builder().id("d_id").name("d_name").type("d_type").manufacturer("d_manufacturer").model("d_model").build();
  String payloadJson=model.getGson().toJson(device);
  Assertions.assertThat(payloadJson).isEqualTo("{\"id\":\"d_id\",\"manufacturer\":\"d_manufacturer\",\"model\":\"d_model\",\"name\":\"d_name\",\"type\":\"d_type\"}");
}
