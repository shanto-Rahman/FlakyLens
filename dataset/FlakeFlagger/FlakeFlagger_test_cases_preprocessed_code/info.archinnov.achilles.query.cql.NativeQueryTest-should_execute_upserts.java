@Test public void should_execute_upserts() throws Exception {
assertThat(actual.getStatement().getQueryString()).isEqualTo(queryString);
assertThat(actual.getValues()).isEqualTo(boundValues);
}