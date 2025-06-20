@Test public void should_persist_and_find_all_types() throws Exception {
assertThat(found.getPrimitiveByte()).isEqualTo((byte)7);
assertThat(found.getObjectByte()).isEqualTo((byte)7);
assertThat(found.getByteArray()).isEqualTo(bytes);
assertThat(found.getByteBuffer()).isEqualTo(ByteBuffer.wrap(bytes));
assertThat(found.isPrimitiveBool()).isTrue();
assertThat(found.getObjectBool()).isTrue();
assertThat(found.getDate()).isEqualTo(now);
assertThat(found.getPrimitiveDouble()).isEqualTo(1.0d);
assertThat(found.getObjectDouble()).isEqualTo(1.0d);
assertThat(found.getBigDecimal()).isEqualTo(new BigDecimal(1.11));
assertThat(found.getPrimitiveFloat()).isEqualTo(1.0f);
assertThat(found.getObjectFloat()).isEqualTo(1.0f);
assertThat(found.getInetAddress()).isEqualTo(inetAddress);
assertThat(found.getBigInt()).isEqualTo(new BigInteger("10"));
assertThat(found.getPrimitiveInt()).isEqualTo(10);
assertThat(found.getObjectInt()).isEqualTo(10);
assertThat(found.getPrimitiveLong()).isEqualTo(10L);
}