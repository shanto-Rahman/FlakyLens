@Test public void properties(){
  JsonObject jsonObject=new JsonObject();
  jsonObject.addProperty("key","value");
  CastleMessage message=CastleMessage.builder("event").properties(jsonObject).build();
  String payloadJson=model.getGson().toJson(message);
  JsonParser parser=new JsonParser();
  String expected="{\"event\":\"event\",\"properties\":{\"key\":\"value\"}}";
  Assertions.assertThat(parser.parse(payloadJson)).isEqualTo(parser.parse(expected));
}
