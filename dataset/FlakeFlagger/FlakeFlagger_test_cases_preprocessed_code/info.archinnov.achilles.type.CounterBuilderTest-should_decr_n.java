@Test public void should_decr_n() throws Exception {
assertThat(counter.get()).isEqualTo(-10L);
}