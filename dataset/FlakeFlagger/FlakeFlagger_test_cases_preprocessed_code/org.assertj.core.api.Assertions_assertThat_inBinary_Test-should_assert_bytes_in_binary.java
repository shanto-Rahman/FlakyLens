@Test public void should_assert_bytes_in_binary(){
assertThat(new byte[]{2,3}).inBinary().isEqualTo(new byte[]{1});
}