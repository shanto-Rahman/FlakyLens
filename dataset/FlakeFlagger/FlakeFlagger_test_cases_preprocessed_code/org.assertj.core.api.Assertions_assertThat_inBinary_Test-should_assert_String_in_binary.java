@Test public void should_assert_String_in_binary(){
assertThat("ab").inBinary().isEqualTo("a6");
}