@Test public void should_create_table_with_compact_storage() throws Exception {
assertThat(built).isEqualTo("\n\tCREATE TABLE test(\n\t\t" + "id bigint,\n\t\t" + "col1 uuid,\n\t\t"+ "col2 uuid,\n\t\t"+ "name text,\n\t\t"+ "PRIMARY KEY(id, col1, col2))\n\t"+ "WITH COMPACT STORAGE");
}