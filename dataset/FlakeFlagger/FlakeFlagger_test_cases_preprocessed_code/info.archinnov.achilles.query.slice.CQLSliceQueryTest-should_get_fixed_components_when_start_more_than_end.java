@Test public void should_get_fixed_components_when_start_more_than_end() throws Exception {
assertThat(cqlSliceQuery.getFixedComponents()).containsExactly(11L,"a");
}