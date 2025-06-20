@Test public void should_get_varying_component_name() throws Exception {
assertThat(cqlSliceQuery.getVaryingComponentName()).isEqualTo("name");
}