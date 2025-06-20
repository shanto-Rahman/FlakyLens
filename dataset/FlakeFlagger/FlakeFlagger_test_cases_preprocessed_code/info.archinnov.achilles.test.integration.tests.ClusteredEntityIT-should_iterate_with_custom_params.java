@Test public void should_iterate_with_custom_params() throws Exception {
assertThat(iter.hasNext()).isTrue();
assertThat(iter.next().getValue()).isEqualTo(clusteredValuePrefix + 2);
assertThat(iter.hasNext()).isTrue();
assertThat(iter.next().getValue()).isEqualTo(clusteredValuePrefix + 3);
assertThat(iter.hasNext()).isTrue();
assertThat(iter.next().getValue()).isEqualTo(clusteredValuePrefix + 4);
assertThat(iter.hasNext()).isTrue();
assertThat(iter.next().getValue()).isEqualTo(clusteredValuePrefix + 5);
assertThat(iter.hasNext()).isFalse();
}