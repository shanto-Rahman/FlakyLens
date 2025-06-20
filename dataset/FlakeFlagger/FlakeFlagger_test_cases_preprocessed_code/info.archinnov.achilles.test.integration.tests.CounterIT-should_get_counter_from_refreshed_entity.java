@Test public void should_get_counter_from_refreshed_entity() throws Exception {
assertThat(version.get()).isEqualTo(5L);
assertThat(bean.getVersion().get()).isEqualTo(5L);
}