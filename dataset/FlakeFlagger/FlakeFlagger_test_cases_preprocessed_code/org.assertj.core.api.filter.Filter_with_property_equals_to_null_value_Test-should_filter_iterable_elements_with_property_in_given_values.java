@Test public void should_filter_iterable_elements_with_property_in_given_values(){
assertThat(filteredPlayers).containsOnly(rose,durant);
assertThat(players).hasSize(4);
}