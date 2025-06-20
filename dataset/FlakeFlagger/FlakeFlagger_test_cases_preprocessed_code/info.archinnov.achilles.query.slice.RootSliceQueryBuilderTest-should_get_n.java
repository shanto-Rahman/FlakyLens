@Test public void should_get_n() throws Exception {
assertThat(actual).isSameAs(result);
assertThat(Whitebox.<Integer>getInternalState(builder,"limit")).isEqualTo(5);
}