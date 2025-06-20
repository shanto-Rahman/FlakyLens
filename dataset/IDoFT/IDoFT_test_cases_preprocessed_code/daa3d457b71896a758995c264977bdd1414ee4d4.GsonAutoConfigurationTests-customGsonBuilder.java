@Test public void customGsonBuilder(){
assertThat(gson.toJson(new DataObject())).isEqualTo("{\"data\":1,\"owner\":null}");
}