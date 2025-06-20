@Test public void should_decr() throws Exception {
assertThat(counter.get()).isEqualTo(-1L);
}