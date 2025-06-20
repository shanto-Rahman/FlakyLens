@Test public void should_notify_listener_when_cas_error_on_native_query() throws Exception {
assertThat(casResult).isNotNull();
assertThat(casResult.operation()).isEqualTo(UPDATE);
assertThat(casResult.currentValues()).isEqualTo(expectedCurrentValues);
}