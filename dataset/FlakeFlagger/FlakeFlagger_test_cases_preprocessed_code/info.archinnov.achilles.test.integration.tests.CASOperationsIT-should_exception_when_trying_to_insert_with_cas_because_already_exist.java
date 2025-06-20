@Test public void should_exception_when_trying_to_insert_with_cas_because_already_exist() throws Exception {
assertThat(casException).isNotNull();
assertThat(casException.operation()).isEqualTo(INSERT);
assertThat(casException.currentValues()).isEqualTo(expectedCurrentValues);
assertThat(casException.toString()).isEqualTo("CAS operation INSERT cannot be applied. Current values are: {[applied]=false, consistency_level=EACH_QUORUM, id=10, name=name}");
}