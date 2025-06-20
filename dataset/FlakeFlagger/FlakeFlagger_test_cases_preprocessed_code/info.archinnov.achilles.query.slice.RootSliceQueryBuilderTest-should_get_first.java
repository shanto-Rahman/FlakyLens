@Test public void should_get_first() throws Exception {
assertThat(actual).isSameAs(entity);
assertThat(Whitebox.<Integer>getInternalState(builder,"limit")).isEqualTo(1);
}