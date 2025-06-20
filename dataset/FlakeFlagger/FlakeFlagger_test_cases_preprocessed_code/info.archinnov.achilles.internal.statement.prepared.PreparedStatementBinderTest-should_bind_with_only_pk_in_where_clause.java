@Test public void should_bind_with_only_pk_in_where_clause() throws Exception {
assertThat(asList(actual.getValues())).containsExactly(primaryKey);
}