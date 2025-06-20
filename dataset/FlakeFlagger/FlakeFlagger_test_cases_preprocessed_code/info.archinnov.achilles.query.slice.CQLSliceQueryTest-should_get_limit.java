@Test public void should_get_limit() throws Exception {
assertThat(cqlSliceQuery.getLimit()).isEqualTo(99);
}