@Test public void should_remove_first() throws Exception {
assertThat(Whitebox.getInternalState(builder,"limit")).isEqualTo(1);
}