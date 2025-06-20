@Test public void should_create_resource_with_a_distinct_keyspace() throws Exception {
assertThat(map.get("count")).isEqualTo(1L);
}