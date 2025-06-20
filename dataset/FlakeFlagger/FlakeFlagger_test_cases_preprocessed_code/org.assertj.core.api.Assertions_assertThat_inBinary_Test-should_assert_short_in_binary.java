@Test public void should_assert_short_in_binary(){
assertThat((short)2).inBinary().isEqualTo((short)3);
}