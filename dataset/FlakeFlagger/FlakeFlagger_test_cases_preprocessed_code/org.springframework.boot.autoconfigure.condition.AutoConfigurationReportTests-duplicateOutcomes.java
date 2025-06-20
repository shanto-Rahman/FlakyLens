@Test public void duplicateOutcomes(){
assertThat(outcomes,not(nullValue()));
assertThat(getNumberOfOutcomes(outcomes),equalTo(2));
assertThat(messages,hasItem(onClassMessage));
}