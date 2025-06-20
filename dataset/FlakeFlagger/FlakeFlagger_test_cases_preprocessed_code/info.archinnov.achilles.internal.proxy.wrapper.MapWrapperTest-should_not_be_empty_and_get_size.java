@Test public void should_not_be_empty_and_get_size() throws Exception {
assertThat(wrapper.isEmpty()).isFalse();
assertThat(wrapper.size()).isEqualTo(3);
}