@Test public void should_get_typed_or_default() throws Exception {
assertThat(counter).isNotNull();
assertThat(counter.get()).isEqualTo(11L);
}