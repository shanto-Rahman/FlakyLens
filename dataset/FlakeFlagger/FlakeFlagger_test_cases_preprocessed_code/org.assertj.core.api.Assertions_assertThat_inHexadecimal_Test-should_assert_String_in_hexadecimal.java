@Test public void should_assert_String_in_hexadecimal(){
assertThat("a6c").inHexadecimal().isEqualTo("abc");
}