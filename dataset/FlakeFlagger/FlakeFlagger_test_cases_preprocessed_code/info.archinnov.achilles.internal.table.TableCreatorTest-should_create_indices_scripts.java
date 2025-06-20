@Test public void should_create_indices_scripts() throws Exception {
assertThat(stringCaptor.getValue()).isEqualTo("\n\tCREATE INDEX tableName_longCol ON tableName(longCol)");
}