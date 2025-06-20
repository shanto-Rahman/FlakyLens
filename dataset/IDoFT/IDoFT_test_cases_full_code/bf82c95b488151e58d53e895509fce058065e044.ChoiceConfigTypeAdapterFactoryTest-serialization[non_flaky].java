@Test public void serialization(){
  final ChoiceConfig<Double> config=new ChoiceConfig<Double>(15.0);
  JsonParser parser=new JsonParser();
  assertThat(parser.parse(this.gson.toJson(config)),is(parser.parse(new GsonBuilder().create().toJson(config))));
}
