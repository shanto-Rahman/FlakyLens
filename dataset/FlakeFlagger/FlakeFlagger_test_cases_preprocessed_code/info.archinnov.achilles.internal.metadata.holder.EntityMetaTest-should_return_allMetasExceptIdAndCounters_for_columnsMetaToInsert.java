@Test public void should_return_allMetasExceptIdAndCounters_for_columnsMetaToInsert() throws Exception {
assertThat(meta.getColumnsMetaToInsert()).isEqualTo(allMetasExceptIdAndCounters);
}