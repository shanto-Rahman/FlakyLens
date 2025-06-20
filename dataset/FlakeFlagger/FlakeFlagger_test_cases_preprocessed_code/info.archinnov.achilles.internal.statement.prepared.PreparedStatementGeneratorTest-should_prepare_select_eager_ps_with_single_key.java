@Test public void should_prepare_select_eager_ps_with_single_key() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(queryCaptor.getValue()).isEqualTo("SELECT name FROM table WHERE id=:id;");
}