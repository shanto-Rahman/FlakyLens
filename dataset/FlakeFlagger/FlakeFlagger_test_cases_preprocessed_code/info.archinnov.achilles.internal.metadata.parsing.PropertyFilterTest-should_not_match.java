@Test public void should_not_match() throws Exception {
assertThat(filter.matches(name)).isFalse();
}