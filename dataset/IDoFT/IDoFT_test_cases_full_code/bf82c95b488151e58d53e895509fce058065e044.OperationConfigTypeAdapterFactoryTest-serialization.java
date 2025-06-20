@Test public void serialization(){
  final OperationConfig config=new OperationConfig(75.0);
  assertThat(this.gson.toJson(config),is(new GsonBuilder().create().toJson(config)));
}
