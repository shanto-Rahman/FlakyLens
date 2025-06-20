@Test public void should_remove_with_runtime_consistency_level_overriding_predefined_one() throws Exception {
assertThat(manager.find(CompleteBean.class,entity.getId())).isNull();
}