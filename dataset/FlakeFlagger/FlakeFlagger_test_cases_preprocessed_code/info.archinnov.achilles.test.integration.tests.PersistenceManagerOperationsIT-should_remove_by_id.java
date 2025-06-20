@Test public void should_remove_by_id() throws Exception {
assertThat(manager.find(CompleteBean.class,entity.getId())).isNull();
assertThat(rows).isEmpty();
}