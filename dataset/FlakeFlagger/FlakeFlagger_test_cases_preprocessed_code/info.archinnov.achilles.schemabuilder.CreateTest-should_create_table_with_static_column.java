@Test public void should_create_table_with_static_column() throws Exception {
assertThat(built).isEqualTo("\n\tCREATE TABLE test(\n\t\t" + "id bigint,\n\t\t" + "col uuid,\n\t\t"+ "bucket int static,\n\t\t"+ "name text,\n\t\t"+ "PRIMARY KEY(id, col))");
}