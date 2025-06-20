@Test public void should_get_fixed_components_when_same_size() throws Exception {
assertThat(cqlSliceQuery.getFixedComponents()).containsExactly(11L,"a");
}