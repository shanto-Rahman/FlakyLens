@Test public void should_increment_from_null_delta() throws Exception {
assertThat(counterImpl.get()).isEqualTo(1L);
}