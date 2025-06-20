@Test public void should_return_first_entity_for_typed_query_with_simple_select() throws Exception {
assertThat(target1.getAge()).isNull();
assertThat(target1.getFollowers()).isNull();
assertThat(target1.getLabel()).isNull();
assertThat(target1.getPreferences()).isNull();
assertThat(target1.getWelcomeTweet()).isNull();
assertThat(Factory.class.isAssignableFrom(actual.getClass())).isTrue();
assertThat(actual.getId()).isEqualTo(entity.getId());
assertThat(actual.getName()).isEqualTo(entity.getName());
assertThat(actual.getFriends()).containsAll(entity.getFriends());
assertThat(actual.getVersion().get()).isEqualTo(15L);
}