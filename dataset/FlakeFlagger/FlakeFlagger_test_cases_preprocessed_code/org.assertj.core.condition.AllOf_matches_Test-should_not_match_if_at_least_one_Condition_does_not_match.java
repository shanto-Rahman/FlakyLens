@Test public void should_not_match_if_at_least_one_Condition_does_not_match(){
assertFalse(allOf.matches("Yoda"));
}