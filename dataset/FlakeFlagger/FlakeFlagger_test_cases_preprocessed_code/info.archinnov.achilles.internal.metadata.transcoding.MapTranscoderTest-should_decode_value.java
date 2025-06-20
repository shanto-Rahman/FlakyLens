@Test public void should_decode_value() throws Exception {
assertThat(transcoder.decode(pm,"value")).isEqualTo("value");
}