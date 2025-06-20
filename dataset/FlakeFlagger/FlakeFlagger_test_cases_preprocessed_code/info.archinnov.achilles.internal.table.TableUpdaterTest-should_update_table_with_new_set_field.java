@Test public void should_update_table_with_new_set_field() throws Exception {
assertThat(stringCaptor.getValue()).isEqualTo("\n\tALTER TABLE tableName ADD set_string set<text>");
}