@Test public void should_return_empty_list_when_no_component_getters() throws Exception {
assertThat(idMeta.getComponentGetters()).isEmpty();
}