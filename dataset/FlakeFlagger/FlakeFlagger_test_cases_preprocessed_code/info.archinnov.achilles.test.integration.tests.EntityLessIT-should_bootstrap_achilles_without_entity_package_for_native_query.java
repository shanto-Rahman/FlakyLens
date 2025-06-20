@Test public void should_bootstrap_achilles_without_entity_package_for_native_query() throws Exception {
assertThat(keyspaceMap).hasSize(1);
assertThat(keyspaceMap.get("keyspace_name")).isEqualTo("system");
}