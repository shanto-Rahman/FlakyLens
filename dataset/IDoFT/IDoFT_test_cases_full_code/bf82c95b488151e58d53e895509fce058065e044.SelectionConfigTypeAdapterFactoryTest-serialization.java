@Test public void serialization(){
  final SelectionConfig<Double> config=new SelectionConfig<Double>();
  config.choices.add(new ChoiceConfig<Double>(15.0));
  assertThat(this.gson.toJson(config),equalToIgnoringCase(new GsonBuilder().create().toJson(config)));
}
