@Test public void should_assert_char_array_in_unicode_representation(){
assertThat("a6c".toCharArray()).inUnicode().isEqualTo("abó".toCharArray());
}