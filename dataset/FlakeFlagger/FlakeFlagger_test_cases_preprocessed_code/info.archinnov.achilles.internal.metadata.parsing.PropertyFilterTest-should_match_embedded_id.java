@Test public void should_match_embedded_id() throws Exception {
assertThat(filter.matches(clusteredId)).isTrue();
}