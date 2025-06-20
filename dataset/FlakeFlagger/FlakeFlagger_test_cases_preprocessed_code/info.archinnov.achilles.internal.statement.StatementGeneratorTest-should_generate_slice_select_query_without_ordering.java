@Test public void should_generate_slice_select_query_without_ordering() throws Exception {
assertThat(actual).isSameAs(statementWrapper);
assertThat(selectCaptor.getValue().getQueryString()).isEqualTo("SELECT id,comp1,comp2,age,name,label FROM table LIMIT 98;");
assertThat(selectCaptor.getValue().getFetchSize()).isEqualTo(101);
}