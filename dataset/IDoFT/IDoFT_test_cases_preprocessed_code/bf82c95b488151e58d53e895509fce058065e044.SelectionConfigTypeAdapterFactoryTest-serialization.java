@Test public void serialization(){
assertThat(this.gson.toJson(config),equalToIgnoringCase(new GsonBuilder().create().toJson(config)));
}