@Test public void should_return_default() throws Exception {
assertThat(counter).isNotNull();
assertThat(counter.get()).isEqualTo(10L);
}