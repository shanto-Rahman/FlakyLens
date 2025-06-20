@Test public void giteeSample() throws Exception {
assertThat(extracted).isNotNull();
assertThat(extracted.getPaths()[0]).isEqualTo("d.txt");
}