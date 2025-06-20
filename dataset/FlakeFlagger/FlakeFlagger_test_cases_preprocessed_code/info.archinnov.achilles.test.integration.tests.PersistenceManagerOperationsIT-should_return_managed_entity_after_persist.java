@Test public void should_return_managed_entity_after_persist() throws Exception {
assertThat(entity).isInstanceOf(Factory.class);
}