@Test public void should_persist_and_get_reference() throws Exception {
assertThat(found.getId()).isEqualTo(compoundKey);
assertThat(found.getValue()).isEqualTo("clustered_value");
}