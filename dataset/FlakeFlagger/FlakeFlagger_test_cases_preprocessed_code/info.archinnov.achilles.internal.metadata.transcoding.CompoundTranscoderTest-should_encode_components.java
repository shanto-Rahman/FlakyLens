@Test public void should_encode_components() throws Exception {
assertThat(actual).containsExactly(userId,"EMBEDDED_ID",name);
}