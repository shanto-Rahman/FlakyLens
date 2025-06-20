@Test public void serialization(){
  final FilesizeConfig config=new FilesizeConfig(15.0);
  assertThat(this.gson.toJson(config),is(new GsonBuilder().create().toJson(config)));
}
