@Test public void serialization(){
assertThat(parser.parse(this.gson.toJson(config).toUpperCase()),is(parser.parse((new GsonBuilder().create().toJson(config).toUpperCase()))));
}