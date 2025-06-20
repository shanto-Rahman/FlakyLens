@Test public void should_decrement_from_null_delta() throws Exception {
assertThat(counterImpl.get()).isEqualTo(-1L);
}