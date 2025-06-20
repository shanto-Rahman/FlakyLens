@Test public void testDuplicateConditionAndOutcomes(){
assertThat(outcome1,equalTo(outcome1));
assertThat(outcome1,not(equalTo(outcome2)));
assertThat(outcome2,equalTo(outcome3));
assertThat(getNumberOfOutcomes(outcomes),equalTo(2));
}