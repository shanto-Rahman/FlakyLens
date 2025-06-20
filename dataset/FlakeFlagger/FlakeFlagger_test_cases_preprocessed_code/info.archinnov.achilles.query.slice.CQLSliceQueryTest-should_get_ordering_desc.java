@Test public void should_get_ordering_desc() throws Exception {
assertThat(Whitebox.getInternalState(ordering,"name")).isEqualTo("orderingComp");
assertThat((Boolean)Whitebox.getInternalState(ordering,"isDesc")).isTrue();
}