@Test public void should_find_accessors_from_collection_types() throws Exception {
assertThat(accessors).hasSize(2);
assertThat(accessors[0].getName()).isEqualTo("getFriends");
assertThat(accessors[1].getName()).isEqualTo("setFriends");
}