@Test public void should_assert_float_in_hexadecimal(){
assertThat(4.3f).inHexadecimal().isEqualTo(2.3f);
}