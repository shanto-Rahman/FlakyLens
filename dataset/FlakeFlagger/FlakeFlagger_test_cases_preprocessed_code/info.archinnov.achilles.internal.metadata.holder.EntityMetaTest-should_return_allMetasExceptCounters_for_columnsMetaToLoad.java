@Test public void should_return_allMetasExceptCounters_for_columnsMetaToLoad() throws Exception {
assertThat(meta.getColumnsMetaToLoad()).isEqualTo(allMetasExceptCounters);
}