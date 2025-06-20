@Test public void should_get_fixed_components_when_start_same_as_end() throws Exception {
assertThat(cqlSliceQuery.getFixedComponents()).containsExactly(11L,"a",12.0);
}