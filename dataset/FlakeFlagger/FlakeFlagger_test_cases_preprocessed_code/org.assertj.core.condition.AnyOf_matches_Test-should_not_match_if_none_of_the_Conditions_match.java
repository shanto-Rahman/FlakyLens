@Test public void should_not_match_if_none_of_the_Conditions_match(){
assertFalse(anyOf.matches("Yoda"));
}