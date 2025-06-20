@Test public void should_unproxy_list_of_entities() throws Exception {
assertThat(actual).containsExactly(realProxy);
}