@Test public void queryUsesOnlyIndicesIncludingTimerangeAndStream() throws Exception {
assertThat(clientRequest).isNotNull();
assertThat(indicesOf(clientRequest).get(0)).isEqualTo("index1,index2");
}