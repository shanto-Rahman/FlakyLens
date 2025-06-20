@Test public void should_filter_iterable_elements_with_property_not_equals_to_given_value(){
assertThat(nonOKCPlayers).containsOnly(rose,noah,james);
assertThat(players).hasSize(4);
assertThat(filteredPlayers).containsOnly(durant,noah,james);
assertThat(players).hasSize(4);
}