@Test public void should_create_complete_table() throws Exception {
assertThat(stringCaptor.getValue()).isEqualTo("\n\tCREATE TABLE tableName(\n" + "\t\tid bigint,\n" + "\t\tlongCol bigint,\n"+ "\t\tlongListCol list<bigint>,\n"+ "\t\tlongSetCol set<bigint>,\n"+ "\t\tlongMapCol map<int,bigint>,\n"+ "\t\tPRIMARY KEY(id))\n"+ "\tWITH comment = 'Create table for entity \"entityName\"'");
}