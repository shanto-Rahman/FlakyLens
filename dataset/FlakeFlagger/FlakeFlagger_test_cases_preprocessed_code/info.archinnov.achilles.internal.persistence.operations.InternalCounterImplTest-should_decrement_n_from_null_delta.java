@Test public void should_decrement_n_from_null_delta() throws Exception {
assertThat(counterImpl.get()).isEqualTo(-2L);
}