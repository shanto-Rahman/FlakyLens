@Test public void serialization(){
  final SelectionConfig<Double> config=new SelectionConfig<Double>();
  config.choices.add(new ChoiceConfig<Double>(15.0));
  JsonParser parser=new JsonParser();
  assertThat(parser.parse(this.gson.toJson(config).toUpperCase()),is(parser.parse((new GsonBuilder().create().toJson(config).toUpperCase()))));
}
