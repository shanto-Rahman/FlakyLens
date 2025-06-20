@Test public void should_remove_n() throws Exception {
assertThat(Whitebox.getInternalState(builder,"limit")).isEqualTo(8);
}