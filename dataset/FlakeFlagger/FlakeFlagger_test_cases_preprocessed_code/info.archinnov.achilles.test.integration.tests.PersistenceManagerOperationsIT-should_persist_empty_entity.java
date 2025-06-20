@Test public void should_persist_empty_entity() throws Exception {
assertThat(found).isNotNull();
assertThat(found.getId()).isEqualTo(entity.getId());
assertThat(found.getFriends()).isNotNull().isEmpty();
assertThat(found.getFollowers()).isNull();
assertThat(found.getPreferences()).isNull();
}