@Test public void should_create_simple_table_if_not_exists() throws Exception {
assertThat(built).isEqualTo("\n\tCREATE TABLE IF NOT EXISTS test(\n\t\t" + "id bigint,\n\t\t" + "name text,\n\t\t"+ "PRIMARY KEY(id))");
}