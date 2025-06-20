@Test public void should_filter_iterable_elements_with_property_equals_to_given_value(){
assertThat(bullsPlayers).containsOnly(rose,noah);
assertThat(players).hasSize(4);
assertThat(filteredPlayers).containsOnly(james);
assertThat(players).hasSize(4);
}