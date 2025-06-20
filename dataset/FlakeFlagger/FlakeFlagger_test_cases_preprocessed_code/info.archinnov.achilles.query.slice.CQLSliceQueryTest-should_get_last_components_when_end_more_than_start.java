@Test public void should_get_last_components_when_end_more_than_start() throws Exception {
assertThat(cqlSliceQuery.getLastStartComponent()).isNull();
assertThat(cqlSliceQuery.getLastEndComponent()).isEqualTo(12.0);
}