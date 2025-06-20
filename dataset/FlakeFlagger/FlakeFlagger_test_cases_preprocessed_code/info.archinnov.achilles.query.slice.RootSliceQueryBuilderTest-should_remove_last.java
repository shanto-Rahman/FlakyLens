@Test public void should_remove_last() throws Exception {
assertThat(Whitebox.getInternalState(builder,"ordering")).isEqualTo(DESCENDING);
assertThat(Whitebox.getInternalState(builder,"limit")).isEqualTo(1);
}