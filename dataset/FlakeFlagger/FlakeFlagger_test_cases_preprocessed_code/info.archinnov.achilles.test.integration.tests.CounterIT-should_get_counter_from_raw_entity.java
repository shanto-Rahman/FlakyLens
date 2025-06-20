@Test public void should_get_counter_from_raw_entity() throws Exception {
assertThat(bean.getVersion().get()).isEqualTo(3L);
}