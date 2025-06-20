@Test public void should_drop_table_with_keyspace() throws Exception {
assertThat(built).isEqualTo("DROP TABLE ks.test");
}