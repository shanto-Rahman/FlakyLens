@Test public void serialization(){
assertThat(parser.parse(this.gson.toJson(config)),is(parser.parse(new GsonBuilder().create().toJson(config))));
}