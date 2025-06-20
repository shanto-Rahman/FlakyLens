@Test public void queryUsesOnlyIndicesBelongingToStream() throws Exception {
assertThat(clientRequest).isNotNull();
assertThat(indicesOf(clientRequest).get(0)).isEqualTo("index1,index2");
}