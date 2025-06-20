@Test public void should_assert_float_in_binary(){
assertThat(2.1f).inBinary().isEqualTo(3f);
}