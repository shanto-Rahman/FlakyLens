@Test public void should_persist_and_get_proxy() throws Exception {
assertThat(found.getId()).isEqualTo(compoundKey);
assertThat(found.getCounter().get()).isEqualTo(counterValue);
assertThat(found.getVersion().get()).isNull();
}