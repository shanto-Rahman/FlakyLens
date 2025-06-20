@Test public void should_return_array() throws Exception {
assertThat(wrapper.toArray()).contains("a","b","c");
}