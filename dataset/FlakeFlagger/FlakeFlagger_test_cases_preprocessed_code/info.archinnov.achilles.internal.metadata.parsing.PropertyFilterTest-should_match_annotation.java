@Test public void should_match_annotation() throws Exception {
assertThat(filter.matches(friends,Column.class)).isTrue();
}