@Test public void should_assert_signed_short_in_binary(){
assertThat((short)-1).inBinary().isEqualTo((short)3);
}