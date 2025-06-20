@Test public void should_decode_primitive_byte_type() throws Exception {
assertThat(actual).isInstanceOf(Byte.class).isEqualTo((byte)7);
}