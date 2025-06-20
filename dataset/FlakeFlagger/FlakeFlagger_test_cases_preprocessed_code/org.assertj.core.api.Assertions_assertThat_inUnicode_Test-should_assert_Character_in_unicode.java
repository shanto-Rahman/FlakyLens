@Test public void should_assert_Character_in_unicode(){
assertThat('o').inUnicode().isEqualTo('ó');
}