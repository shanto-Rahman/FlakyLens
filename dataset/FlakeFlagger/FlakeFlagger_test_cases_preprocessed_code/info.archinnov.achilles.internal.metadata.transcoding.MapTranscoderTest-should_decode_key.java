@Test public void should_decode_key() throws Exception {
assertThat(transcoder.decodeKey(pm,11)).isEqualTo(11);
}