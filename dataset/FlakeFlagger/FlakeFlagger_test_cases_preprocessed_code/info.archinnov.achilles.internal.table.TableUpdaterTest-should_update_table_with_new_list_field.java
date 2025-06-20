@Test public void should_update_table_with_new_list_field() throws Exception {
assertThat(stringCaptor.getValue()).isEqualTo("\n\tALTER TABLE tableName ADD list_string list<text>");
}