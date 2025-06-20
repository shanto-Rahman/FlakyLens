@Test public void should_encode_value() throws Exception {
assertThat(transcoder.encode(pm,"value")).isEqualTo("value");
}