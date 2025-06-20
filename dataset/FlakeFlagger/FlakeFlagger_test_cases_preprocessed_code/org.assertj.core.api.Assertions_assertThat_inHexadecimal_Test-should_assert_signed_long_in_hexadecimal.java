@Test public void should_assert_signed_long_in_hexadecimal(){
assertThat(-2L).inHexadecimal().isEqualTo(2L);
}