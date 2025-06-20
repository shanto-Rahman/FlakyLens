@Test public void should_create_complete_table_with_clustering_order() throws Exception {
assertThat(stringCaptor.getValue()).isEqualTo("\n\tCREATE TABLE tableName(\n" + "\t\tid bigint,\n" + "\t\tname text,\n"+ "\t\tlongCol bigint,\n"+ "\t\tPRIMARY KEY(id, name))\n"+ "\tWITH comment = 'Create table for entity \"entityName\"'"+ " AND CLUSTERING ORDER BY(name DESC)");
}