@Test public void should_create_simple_table_with_set() throws Exception {
assertThat(built).isEqualTo("\n\tCREATE TABLE test(\n\t\t" + "id bigint,\n\t\t" + "friends set<text>,\n\t\t"+ "PRIMARY KEY(id))");
}