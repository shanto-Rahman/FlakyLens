@Test public void should_iterate_over_clusterings_components() throws Exception {
assertThat(iterator.hasNext()).isTrue();
assertThat(iterator.next().getValue()).isEqualTo("val11");
assertThat(iterator.hasNext()).isTrue();
assertThat(iterator.next().getValue()).isEqualTo("val12");
assertThat(iterator.hasNext()).isTrue();
assertThat(iterator.next().getValue()).isEqualTo("val13");
assertThat(iterator.hasNext()).isTrue();
assertThat(iterator.next().getValue()).isEqualTo("val21");
assertThat(iterator.hasNext()).isTrue();
assertThat(iterator.next().getValue()).isEqualTo("val22");
assertThat(iterator.hasNext()).isTrue();
assertThat(iterator.next().getValue()).isEqualTo("val31");
assertThat(iterator.hasNext()).isFalse();
}