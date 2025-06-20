@Test public void serialization(){
  final ContainerConfig config=new ContainerConfig("vault");
  JsonParser parser=new JsonParser();
  assertThat(parser.parse(this.gson.toJson(config)),is(parser.parse(new GsonBuilder().create().toJson(config))));
}
