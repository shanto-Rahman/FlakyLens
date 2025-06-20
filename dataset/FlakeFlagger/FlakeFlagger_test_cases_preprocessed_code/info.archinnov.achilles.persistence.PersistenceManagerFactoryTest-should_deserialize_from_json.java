@Test public void should_deserialize_from_json() throws Exception {
assertThat(actual.getId()).isEqualTo(10L);
assertThat(actual.getName()).isEqualTo("name");
assertThat(actual.getFriends()).isNull();
assertThat(actual.getFollowers()).isNull();
assertThat(actual.getPreferences()).isNull();
}