@Test public void serialization(){
  final ContainerConfig config=new ContainerConfig("vault");
  assertThat(this.gson.toJson(config),is(new GsonBuilder().create().toJson(config)));
}
