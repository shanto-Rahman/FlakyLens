@Test public void should_get_bound_statement() throws Exception {
assertThat(simpleStatement.getQueryString()).isEqualTo("SELECT");
}