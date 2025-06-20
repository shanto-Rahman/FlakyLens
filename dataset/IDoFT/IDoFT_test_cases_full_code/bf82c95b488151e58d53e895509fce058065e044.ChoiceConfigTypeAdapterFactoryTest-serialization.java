@Test public void serialization(){
  final ChoiceConfig<Double> config=new ChoiceConfig<Double>(15.0);
  assertThat(this.gson.toJson(config),is(new GsonBuilder().create().toJson(config)));
}
