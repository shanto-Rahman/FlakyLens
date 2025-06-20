@Test public void should_update_table_with_new_map_field() throws Exception {
assertThat(stringCaptor.getValue()).isEqualTo("\n\tALTER TABLE tableName ADD preferences map<int, text>");
}