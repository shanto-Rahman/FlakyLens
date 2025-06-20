@Test public void should_get_last_components_when_start_same_as_end() throws Exception {
assertThat(cqlSliceQuery.getLastStartComponent()).isNull();
assertThat(cqlSliceQuery.getLastEndComponent()).isNull();
}