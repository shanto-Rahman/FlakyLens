@Test public void should_assert_bytes_contains_in_hexadecimal(){
assertThat(new byte[]{2,3}).inHexadecimal().contains(new byte[]{1});
}