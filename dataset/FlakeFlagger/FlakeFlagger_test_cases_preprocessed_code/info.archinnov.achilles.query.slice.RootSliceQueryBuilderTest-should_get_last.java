@Test public void should_get_last() throws Exception {
assertThat(actual).isSameAs(entity);
assertThat(Whitebox.getInternalState(builder,"ordering")).isEqualTo(DESCENDING);
assertThat(Whitebox.getInternalState(builder,"limit")).isEqualTo(1);
}