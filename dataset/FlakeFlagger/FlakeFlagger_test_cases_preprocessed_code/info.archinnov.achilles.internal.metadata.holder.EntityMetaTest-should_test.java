@Test public void should_test() throws Exception {
assertThat(pattern.matcher(text).find()).isTrue();
}