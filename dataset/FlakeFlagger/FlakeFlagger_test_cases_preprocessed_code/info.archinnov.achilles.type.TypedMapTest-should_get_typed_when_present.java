@Test public void should_get_typed_when_present() throws Exception {
assertThat(counter).isNotNull();
assertThat(counter.get()).isEqualTo(10L);
}