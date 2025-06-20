@Test public void should_assert_floats_in_hexadecimal(){
assertThat(new float[]{4.3f,-2f}).inHexadecimal().isEqualTo(new float[]{4.1f});
}