@Test public void should_assert_bytes_in_hexadecimal(){
assertThat(new byte[]{2,3}).inHexadecimal().isEqualTo(new byte[]{1});
}