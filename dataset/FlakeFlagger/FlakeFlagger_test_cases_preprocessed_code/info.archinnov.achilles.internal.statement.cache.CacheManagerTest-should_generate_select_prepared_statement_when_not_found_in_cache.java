@Test public void should_generate_select_prepared_statement_when_not_found_in_cache() throws Exception {
assertThat(actual).isSameAs(ps);
}