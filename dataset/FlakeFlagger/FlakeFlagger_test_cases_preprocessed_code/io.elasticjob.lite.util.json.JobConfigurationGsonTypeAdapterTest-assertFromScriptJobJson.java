@Test public void assertFromScriptJobJson(){
assertThat(GsonFactory.getGson().toJson(actual),is(GsonFactory.getGson().toJson(expected)));
}