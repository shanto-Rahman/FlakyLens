@Test public void should_prepare_select_field_ps_for_clustered_id() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(queryCaptor.getValue()).isEqualTo("SELECT id,a,b FROM table WHERE id=:id AND a=:a AND b=:b;");
}