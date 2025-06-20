@Test public void should_get_meta() throws Exception {
assertThat(cqlSliceQuery.getMeta()).isSameAs(meta);
}