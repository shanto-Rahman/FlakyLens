@Test public void should_get_counter_from_managed__entity_after_setting_value() throws Exception {
assertThat(bean.getVersion().get()).isEqualTo(5L);
}