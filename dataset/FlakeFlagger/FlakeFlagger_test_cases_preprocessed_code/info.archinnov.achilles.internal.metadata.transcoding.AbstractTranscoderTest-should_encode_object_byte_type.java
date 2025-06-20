@Test public void should_encode_object_byte_type() throws Exception {
assertThat(actual).isInstanceOf(ByteBuffer.class);
assertThat(byteBuffer.array()[0]).isEqualTo((byte)7);
}