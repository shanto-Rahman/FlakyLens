@Test public void should_assert_double_in_binary(){
assertThat(2.1d).inBinary().isEqualTo(3d);
}