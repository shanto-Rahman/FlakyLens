@Test public void should_get_first_n() throws Exception {
assertThat(Whitebox.<Integer>getInternalState(builder,"limit")).isEqualTo(3);
}