@Test public void should_get_component_setters() throws Exception {
assertThat(idMeta.getComponentSetters()).containsExactly(idSetter,nameSetter);
}