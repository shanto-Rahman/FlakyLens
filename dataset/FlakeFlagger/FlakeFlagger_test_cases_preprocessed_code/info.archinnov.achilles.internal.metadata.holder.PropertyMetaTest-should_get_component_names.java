@Test public void should_get_component_names() throws Exception {
assertThat(idMeta.getComponentNames()).containsExactly("a","b");
}