@Test public void should_assert_negative_long_in_binary(){
assertThat((long)-2).inBinary().isEqualTo((long)3);
}