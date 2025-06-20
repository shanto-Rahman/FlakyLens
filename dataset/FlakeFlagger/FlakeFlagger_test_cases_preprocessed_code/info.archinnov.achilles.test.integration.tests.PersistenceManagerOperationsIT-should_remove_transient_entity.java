@Test public void should_remove_transient_entity() throws Exception {
assertThat(manager.find(CompleteBean.class,entity.getId())).isNull();
}