@Test public void should_assert_negative_integer_in_binary(){
assertThat(3).inBinary().isEqualTo(-3);
}