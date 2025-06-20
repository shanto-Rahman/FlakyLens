@Test public void should_notify_listener_on_cas_error() throws Exception {
assertThat(caughtEx).isNotNull();
assertThat(caughtEx.operation()).isEqualTo(INSERT);
assertThat(caughtEx.currentValues()).contains(MapEntry.entry("[applied]",false),MapEntry.entry("id",10L));
}