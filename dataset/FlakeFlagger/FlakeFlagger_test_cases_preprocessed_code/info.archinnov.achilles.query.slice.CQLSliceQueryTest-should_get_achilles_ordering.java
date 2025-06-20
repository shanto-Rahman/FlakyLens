@Test public void should_get_achilles_ordering() throws Exception {
assertThat(cqlSliceQuery.getOrdering()).isSameAs(ASCENDING);
}