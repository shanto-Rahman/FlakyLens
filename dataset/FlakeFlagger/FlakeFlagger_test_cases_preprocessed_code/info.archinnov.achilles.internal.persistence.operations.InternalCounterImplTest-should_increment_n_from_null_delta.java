@Test public void should_increment_n_from_null_delta() throws Exception {
assertThat(counterImpl.get()).isEqualTo(2L);
}