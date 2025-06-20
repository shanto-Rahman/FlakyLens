@Test public void should_drop_table_with_keyspace_if_exists() throws Exception {
assertThat(built).isEqualTo("DROP TABLE IF EXISTS ks.test");
}