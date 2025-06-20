@Test public void serialization(){
assertThat(this.gson.toJson(config),is(new GsonBuilder().create().toJson(config)));
}