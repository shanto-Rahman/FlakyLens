@Test public void should_exception_when_failing_cas_update() throws Exception {
assertThat(casException).isNotNull();
assertThat(casException.operation()).isEqualTo(UPDATE);
assertThat(casException.currentValues()).isEqualTo(expectedCurrentValues);
assertThat(casException.toString()).isEqualTo("CAS operation UPDATE cannot be applied. Current values are: {[applied]=false, consistency_level=EACH_QUORUM, name=John}");
}