@Test public void should_assert_String_in_unicode(){
assertThat("a6c").inUnicode().isEqualTo("abó");
}