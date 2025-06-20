@Test public void should_return_null_when_no_first() throws Exception {
assertThat(actual).isNull();
assertThat(Whitebox.getInternalState(builder,"limit")).isEqualTo(1);
}