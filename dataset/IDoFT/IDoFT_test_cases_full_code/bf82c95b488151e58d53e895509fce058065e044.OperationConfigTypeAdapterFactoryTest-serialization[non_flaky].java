@Test public void serialization(){
  final OperationConfig config=new OperationConfig(75.0);
  JsonParser parser=new JsonParser();
  assertThat(parser.parse(this.gson.toJson(config)),is(parser.parse(new GsonBuilder().create().toJson(config))));
}
