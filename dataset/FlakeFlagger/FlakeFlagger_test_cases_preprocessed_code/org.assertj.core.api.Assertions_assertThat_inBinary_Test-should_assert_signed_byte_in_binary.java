@Test public void should_assert_signed_byte_in_binary(){
assertThat((byte)-2).inBinary().isEqualTo((byte)3);
}