@Test public void should_get_last_components_when_same_size() throws Exception {
assertThat(cqlSliceQuery.getLastStartComponent()).isEqualTo(11.0);
assertThat(cqlSliceQuery.getLastEndComponent()).isEqualTo(12.0);
}