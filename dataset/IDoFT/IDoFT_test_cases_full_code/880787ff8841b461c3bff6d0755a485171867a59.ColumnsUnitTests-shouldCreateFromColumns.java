@Test void shouldCreateFromColumns(){
  Columns columns=Columns.from("asc","bar");
  assertThat(columns.toString()).isEqualTo("asc, bar");
}
