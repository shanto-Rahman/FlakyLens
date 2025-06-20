@Test public void should_create_simple_table_with_keyspace() throws Exception {
assertThat(built).isEqualTo("\n\tCREATE TABLE ks.test(\n\t\t" + "id bigint,\n\t\t" + "name text,\n\t\t"+ "PRIMARY KEY(id))");
}