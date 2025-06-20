@Test public void should_remove_property_after_merge() throws Exception {
assertThat(found.getName()).isNull();
assertThat(found.getFriends()).isNotNull().isEmpty();
assertThat(found.getFollowers()).isNull();
assertThat(found.getPreferences()).isNull();
}