@Test public void should_generate_slice_delete_query() throws Exception {
assertThat(actual).isSameAs(statementWrapper);
assertThat(deleteCaptor.getValue().getQueryString()).isEqualTo("DELETE  FROM table;");
}