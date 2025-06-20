@Test public void should_match() throws Exception {
assertThat(filter.matches(name)).isTrue();
}