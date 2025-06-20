@Test public void should_notify_listener_on_cas_update_failure() throws Exception {
assertThat(casResult).isNotNull();
assertThat(casResult.operation()).isEqualTo(UPDATE);
assertThat(casResult.currentValues()).isEqualTo(expectedCurrentValues);
}