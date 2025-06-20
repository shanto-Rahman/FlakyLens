@Test public void should_get_indexed_query() throws Exception {
assertThat(Whitebox.<Object[]>getInternalState(typedQuery,"encodedBoundValues")).contains("value");
}