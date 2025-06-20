@Test public void should_get_bounding() throws Exception {
assertThat(cqlSliceQuery.getBounding()).isEqualTo(INCLUSIVE_END_BOUND_ONLY);
}