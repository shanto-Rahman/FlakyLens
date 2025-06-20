@Test public void should_update_table_with_new_indexed_simple_field() throws Exception {
assertThat(updates.get(0)).isEqualTo("\n\tALTER TABLE tableName ADD longCol bigint");
assertThat(updates.get(1)).isEqualTo("\n\tCREATE INDEX long_index ON tableName(longCol)");
}