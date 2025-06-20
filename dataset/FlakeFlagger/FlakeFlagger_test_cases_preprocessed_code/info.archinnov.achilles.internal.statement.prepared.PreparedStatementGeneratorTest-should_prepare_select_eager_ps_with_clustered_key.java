@Test public void should_prepare_select_eager_ps_with_clustered_key() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(queryCaptor.getValue()).isEqualTo("SELECT id,a,b,name FROM table WHERE id=:id AND a=:a AND b=:b;");
}