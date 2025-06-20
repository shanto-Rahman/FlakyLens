@Test public void should_return_true_for_contains_all() throws Exception {
assertThat(listWrapper.containsAll(asList("a","c"))).isTrue();
}