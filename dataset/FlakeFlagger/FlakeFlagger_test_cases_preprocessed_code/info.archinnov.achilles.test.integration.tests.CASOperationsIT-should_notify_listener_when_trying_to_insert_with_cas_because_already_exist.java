@Test public void should_notify_listener_when_trying_to_insert_with_cas_because_already_exist() throws Exception {
assertThat(casResult.operation()).isEqualTo(INSERT);
assertThat(casResult.currentValues()).isEqualTo(expectedCurrentValues);
assertThat(casResult.toString()).isEqualTo("CAS operation INSERT cannot be applied. Current values are: {[applied]=false, consistency_level=EACH_QUORUM, id=10, name=name}");
}