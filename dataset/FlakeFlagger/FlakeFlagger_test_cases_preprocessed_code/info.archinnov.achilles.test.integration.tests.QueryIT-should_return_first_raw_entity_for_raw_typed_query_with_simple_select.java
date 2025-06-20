@Test public void should_return_first_raw_entity_for_raw_typed_query_with_simple_select() throws Exception {
assertThat(Factory.class.isAssignableFrom(actual.getClass())).isFalse();
assertThat(actual.getId()).isEqualTo(entity.getId());
assertThat(actual.getName()).isEqualTo(entity.getName());
assertThat(actual.getLabel()).isNull();
assertThat(actual.getAge()).isNull();
assertThat(actual.getFriends()).containsAll(entity.getFriends());
assertThat(actual.getFollowers()).isNull();
assertThat(actual.getPreferences()).isNull();
assertThat(actual.getVersion()).isNull();
assertThat(actual.getWelcomeTweet()).isNull();
}