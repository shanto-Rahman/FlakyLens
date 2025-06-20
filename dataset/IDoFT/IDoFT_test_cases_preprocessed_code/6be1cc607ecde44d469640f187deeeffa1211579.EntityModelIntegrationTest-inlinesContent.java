@Test void inlinesContent() throws Exception {
assertThat(write(resource)).isEqualTo(REFERENCE);
}