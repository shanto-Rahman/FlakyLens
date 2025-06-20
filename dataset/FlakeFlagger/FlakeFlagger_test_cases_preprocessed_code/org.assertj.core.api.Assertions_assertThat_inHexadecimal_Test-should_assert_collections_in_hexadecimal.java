@Test public void should_assert_collections_in_hexadecimal(){
assertThat(Arrays.asList(1,2)).inHexadecimal().isEqualTo(Arrays.asList(3));
}