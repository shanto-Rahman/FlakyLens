@Test public void should_throw_exception_on_cas_error() throws Exception {
assertThat(actual).isNotNull();
assertThat(actual.operation()).isEqualTo(UPDATE);
assertThat(actual.currentValues()).contains(MapEntry.entry("[applied]",false),MapEntry.entry("name","Helen"));
}