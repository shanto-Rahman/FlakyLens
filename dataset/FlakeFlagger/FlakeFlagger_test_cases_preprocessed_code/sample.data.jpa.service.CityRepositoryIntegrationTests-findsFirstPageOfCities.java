@Test public void findsFirstPageOfCities(){
assertThat(cities.getTotalElements(),is(greaterThan(20L)));
}