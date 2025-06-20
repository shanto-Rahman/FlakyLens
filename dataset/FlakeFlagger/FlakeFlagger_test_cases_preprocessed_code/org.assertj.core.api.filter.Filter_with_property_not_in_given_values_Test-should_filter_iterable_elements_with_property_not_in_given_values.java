@Test public void should_filter_iterable_elements_with_property_not_in_given_values(){
assertThat(filteredPlayers).containsOnly(rose,noah);
assertThat(players).hasSize(4);
assertThat(filteredPlayers).containsOnly(durant,james);
assertThat(players).hasSize(4);
}