@Test public void should_encode_byte_array_type() throws Exception {
assertThat(actual).isInstanceOf(ByteBuffer.class);
assertThat(byteBuffer.array()[0]).isEqualTo((byte)7);
}