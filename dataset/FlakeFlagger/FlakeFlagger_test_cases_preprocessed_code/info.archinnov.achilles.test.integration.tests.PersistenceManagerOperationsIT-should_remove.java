@Test public void should_remove() throws Exception {
assertThat(manager.find(CompleteBean.class,entity.getId())).isNull();
assertThat(rows).isEmpty();
}