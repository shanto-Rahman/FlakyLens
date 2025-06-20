@Test public void should_match_annotation_and_name() throws Exception {
assertThat(filter.matches(friends,Column.class,"friends")).isTrue();
}