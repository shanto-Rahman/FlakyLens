@Test public void should_execute_cas_successfully() throws Exception {
casSuccess.compareAndSet(false,true);
assertThat(casSuccess.get()).isTrue();
}