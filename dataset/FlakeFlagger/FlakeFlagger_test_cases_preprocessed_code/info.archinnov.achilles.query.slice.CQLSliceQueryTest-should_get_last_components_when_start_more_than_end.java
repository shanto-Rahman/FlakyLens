@Test public void should_get_last_components_when_start_more_than_end() throws Exception {
assertThat(cqlSliceQuery.getLastStartComponent()).isEqualTo(11.0);
assertThat(cqlSliceQuery.getLastEndComponent()).isNull();
}