@Test public void should_remove_first_n() throws Exception {
assertThat(Whitebox.getInternalState(builder,"limit")).isEqualTo(9);
}