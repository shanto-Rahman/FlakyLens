@Test public void should_persist_and_find() throws Exception {
assertThat(found.getId()).isEqualTo(compoundKey);
assertThat(found.getValue()).isEqualTo("clustered_value");
}