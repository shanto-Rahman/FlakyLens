@Test public void should_prepare_select_field_ps() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(queryCaptor.getValue()).isEqualTo("SELECT name FROM table WHERE id=:id;");
}