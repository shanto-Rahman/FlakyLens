@Test public void should_return_array_with_argument() throws Exception {
assertThat(wrapper.toArray(new String[]{"a","c"})).contains("a","c");
}