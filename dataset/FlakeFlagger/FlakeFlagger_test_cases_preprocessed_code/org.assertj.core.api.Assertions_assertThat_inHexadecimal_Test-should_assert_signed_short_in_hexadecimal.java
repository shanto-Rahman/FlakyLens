@Test public void should_assert_signed_short_in_hexadecimal(){
assertThat((short)-2).inHexadecimal().isEqualTo((short)3);
}