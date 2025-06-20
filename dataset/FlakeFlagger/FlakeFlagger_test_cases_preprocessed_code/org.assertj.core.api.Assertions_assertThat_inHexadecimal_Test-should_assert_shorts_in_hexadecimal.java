@Test public void should_assert_shorts_in_hexadecimal(){
assertThat(new short[]{(short)1,(short)2}).inHexadecimal().isEqualTo(new short[]{(short)3});
}