@Test public void should_create_table_with_clustering_order() throws Exception {
assertThat(built).isEqualTo("\n\tCREATE TABLE test(\n\t\t" + "id bigint,\n\t\t" + "col1 uuid,\n\t\t"+ "col2 uuid,\n\t\t"+ "name text,\n\t\t"+ "PRIMARY KEY(id, col1, col2))\n\t"+ "WITH CLUSTERING ORDER BY(col1 ASC, col2 DESC)");
}