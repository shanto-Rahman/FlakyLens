@Test public void should_assert_double_in_hexadecimal(){
assertThat(4.3d).inHexadecimal().isEqualTo(2.3d);
}