@Test public void should_assert_doubles_in_hexadecimal(){
assertThat(new double[]{1d,2d}).inHexadecimal().isEqualTo(new double[]{3d});
}