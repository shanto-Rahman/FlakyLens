@Test public void should_unproxy_collection_of_entities() throws Exception {
assertThat(actual).containsExactly(realProxy);
}