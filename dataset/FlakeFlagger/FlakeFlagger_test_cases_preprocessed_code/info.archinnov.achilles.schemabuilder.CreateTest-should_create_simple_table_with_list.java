@Test public void should_create_simple_table_with_list() throws Exception {
assertThat(built).isEqualTo("\n\tCREATE TABLE test(\n\t\t" + "id bigint,\n\t\t" + "friends list<text>,\n\t\t"+ "PRIMARY KEY(id))");
}