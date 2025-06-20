@Test public void should_get_components_name() throws Exception {
assertThat(cqlSliceQuery.getComponentNames()).containsExactly("id","count","name");
}