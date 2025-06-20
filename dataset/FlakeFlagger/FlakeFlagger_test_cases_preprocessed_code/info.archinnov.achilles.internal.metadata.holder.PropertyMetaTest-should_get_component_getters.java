@Test public void should_get_component_getters() throws Exception {
assertThat(idMeta.getComponentGetters()).containsExactly(idGetter,nameGetter);
}