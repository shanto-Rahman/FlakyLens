@Test public void should_assert_integers_in_hexadecimal(){
assertThat(new int[]{1,2}).inHexadecimal().isEqualTo(new int[]{2});
}