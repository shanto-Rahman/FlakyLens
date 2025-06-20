@Test public void should_serialized_proxified_entity_with_Jackson() throws Exception {
assertThat(serialized).doesNotContain("allback");
assertThat(deserialized).isNotInstanceOf(Factory.class);
assertThat(deserialized.getId()).isEqualTo(bean.getId());
assertThat(deserialized.getName()).isEqualTo(bean.getName());
assertThat(deserialized.getVersion().get()).isEqualTo(bean.getVersion().get());
}