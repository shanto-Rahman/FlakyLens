@Test public void should_assert_longs_in_hexadecimal(){
assertThat(new long[]{-1L,2L}).inHexadecimal().isEqualTo(new long[]{3L});
}