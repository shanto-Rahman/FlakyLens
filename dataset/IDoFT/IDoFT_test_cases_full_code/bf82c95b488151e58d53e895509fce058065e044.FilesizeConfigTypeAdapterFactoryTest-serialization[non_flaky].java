@Test public void serialization(){
  final FilesizeConfig config=new FilesizeConfig(15.0);
  JsonParser parser=new JsonParser();
  assertThat(parser.parse(this.gson.toJson(config)),is(parser.parse(new GsonBuilder().create().toJson(config))));
}
