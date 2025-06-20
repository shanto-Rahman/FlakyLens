@Test public void should_encode_key() throws Exception {
assertThat(transcoder.encodeKey(pm,11)).isEqualTo(11);
}