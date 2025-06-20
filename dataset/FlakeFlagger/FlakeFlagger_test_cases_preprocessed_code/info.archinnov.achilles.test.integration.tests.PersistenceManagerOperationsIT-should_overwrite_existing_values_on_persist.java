@Test public void should_overwrite_existing_values_on_persist() throws Exception {
assertThat(entity.getFriends()).isNotNull().isEmpty();
assertThat(entity.getFollowers()).isNull();
assertThat(entity.getPreferences()).isNull();
}