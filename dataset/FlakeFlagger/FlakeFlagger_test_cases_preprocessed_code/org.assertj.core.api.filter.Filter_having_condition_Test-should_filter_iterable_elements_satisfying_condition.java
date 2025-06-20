@Test public void should_filter_iterable_elements_satisfying_condition(){
assertThat(playersHavinMvpStats).containsOnly(rose,james);
assertThat(players).hasSize(4);
}