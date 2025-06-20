@Test public void properties(){
  JsonObject jsonObject=new JsonObject();
  jsonObject.addProperty("key","value");
  CastleMessage message=CastleMessage.builder("event").properties(jsonObject).build();
  String payloadJson=model.getGson().toJson(message);
  Assertions.assertThat(payloadJson).isEqualTo("{\"event\":\"event\",\"properties\":{\"key\":\"value\"}}");
}
