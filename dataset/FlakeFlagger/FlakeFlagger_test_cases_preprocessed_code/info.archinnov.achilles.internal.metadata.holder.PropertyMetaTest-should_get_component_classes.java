@Test public void should_get_component_classes() throws Exception {
assertThat(idMeta.getComponentClasses()).containsExactly(Long.class,String.class);
}