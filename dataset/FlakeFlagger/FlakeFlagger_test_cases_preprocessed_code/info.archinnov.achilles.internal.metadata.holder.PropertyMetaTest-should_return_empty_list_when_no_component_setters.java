@Test public void should_return_empty_list_when_no_component_setters() throws Exception {
assertThat(idMeta.getComponentSetters()).isEmpty();
}