@Test public void should_notify_listener_when_failing_cas_update_with_ttl() throws Exception {
assertThat(casResult).isNotNull();
assertThat(casResult.operation()).isEqualTo(UPDATE);
assertThat(casResult.currentValues()).isEqualTo(expectedCurrentValues);
assertThat(casResult.toString()).isEqualTo("CAS operation UPDATE cannot be applied. Current values are: {[applied]=false, consistency_level=EACH_QUORUM, name=John}");
}