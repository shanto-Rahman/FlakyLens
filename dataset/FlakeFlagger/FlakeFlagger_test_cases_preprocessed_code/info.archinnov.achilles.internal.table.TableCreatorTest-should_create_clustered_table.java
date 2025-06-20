@Test public void should_create_clustered_table() throws Exception {
assertThat(stringCaptor.getValue()).isEqualTo("\n\tCREATE TABLE tableName(\n" + "\t\tindexCol bigint,\n" + "\t\tcount int,\n"+ "\t\tuuid timeuuid,\n"+ "\t\tlongCol bigint,\n"+ "\t\tPRIMARY KEY(indexCol, count, uuid))\n"+ "\tWITH comment = 'Create table for entity \"entityName\"' AND CLUSTERING ORDER BY(count DESC)");
}