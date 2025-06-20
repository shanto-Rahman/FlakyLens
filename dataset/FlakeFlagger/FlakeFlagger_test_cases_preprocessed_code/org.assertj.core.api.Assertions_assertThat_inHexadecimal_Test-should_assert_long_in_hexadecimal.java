@Test public void should_assert_long_in_hexadecimal(){
assertThat(Long.MAX_VALUE).inHexadecimal().isEqualTo(Long.MIN_VALUE);
}