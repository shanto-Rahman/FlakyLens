@Test public void should_bootstrap_embedded_server_and_entity_manager() throws Exception {
assertThat(row).isNotNull();
assertThat(row.getString("firstname")).isEqualTo("fn");
assertThat(row.getString("lastname")).isEqualTo("ln");
}