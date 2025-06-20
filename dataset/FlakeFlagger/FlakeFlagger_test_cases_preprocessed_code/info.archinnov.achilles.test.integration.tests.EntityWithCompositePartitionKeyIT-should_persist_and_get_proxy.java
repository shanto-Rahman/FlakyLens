@Test public void should_persist_and_get_proxy() throws Exception {
assertThat(found.getId()).isEqualTo(compositeRowKey);
assertThat(found.getValue()).isEqualTo("clustered_value");
}