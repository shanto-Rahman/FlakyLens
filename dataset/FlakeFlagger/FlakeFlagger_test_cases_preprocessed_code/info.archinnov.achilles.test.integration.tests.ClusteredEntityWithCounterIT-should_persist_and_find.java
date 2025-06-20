@Test public void should_persist_and_find() throws Exception {
assertThat(found.getId()).isEqualTo(compoundKey);
assertThat(found.getCounter().get()).isEqualTo(counterValue);
assertThat(found.getVersion().get()).isEqualTo(versionValue);
}