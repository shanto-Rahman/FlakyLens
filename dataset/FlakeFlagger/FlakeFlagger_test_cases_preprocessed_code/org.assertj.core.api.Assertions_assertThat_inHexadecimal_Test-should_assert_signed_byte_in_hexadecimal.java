@Test public void should_assert_signed_byte_in_hexadecimal(){
assertThat((byte)-2).inHexadecimal().isEqualTo((byte)3);
}