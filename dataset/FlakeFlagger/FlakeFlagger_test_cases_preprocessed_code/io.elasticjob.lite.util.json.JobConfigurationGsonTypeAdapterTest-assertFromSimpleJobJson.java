@Test public void assertFromSimpleJobJson(){
assertThat(GsonFactory.getGson().toJson(actual),is(GsonFactory.getGson().toJson(expected)));
}