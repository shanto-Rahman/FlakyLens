@Test public void should_eager_load_entity() throws Exception {
assertThat(facade.loadEntity()).isSameAs(row);
}