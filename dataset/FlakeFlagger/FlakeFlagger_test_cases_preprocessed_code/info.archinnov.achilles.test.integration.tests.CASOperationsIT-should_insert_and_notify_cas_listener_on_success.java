@Test public void should_insert_and_notify_cas_listener_on_success() throws Exception {
casSuccess.compareAndSet(false,true);
assertThat(found).isNotNull();
assertThat(found.getName()).isEqualTo("name");
assertThat(found.getConsistencyLevel()).isEqualTo(EACH_QUORUM);
assertThat(casSuccess.get()).isTrue();
}