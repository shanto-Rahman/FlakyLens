@Test public void testNormalize() throws Exception {
assertThat(converter.convertTo(results)).isEqualTo(normalized);
}