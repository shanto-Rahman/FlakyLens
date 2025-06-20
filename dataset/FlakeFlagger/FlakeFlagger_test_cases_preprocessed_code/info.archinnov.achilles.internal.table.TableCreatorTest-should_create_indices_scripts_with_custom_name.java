@Test public void should_create_indices_scripts_with_custom_name() throws Exception {
assertThat(stringCaptor.getValue()).isEqualTo("\n\tCREATE INDEX myIndex ON tableName(longCol)");
}