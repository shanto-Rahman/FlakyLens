@Test public void should_decode_byte_array_type() throws Exception {
assertThat(actual).isInstanceOf(byte[].class);
assertThat(byteArray[0]).isEqualTo((byte)7);
}