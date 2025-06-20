@Test public void executesQueryMethodsCorrectly(){
assertThat(city.getName(),is("Atlanta"));
assertThat(hotel.getName(),is("Doubletree"));
assertThat(counts,hasSize(1));
assertThat(counts.get(0).getRating(),is(Rating.AVERAGE));
assertThat(counts.get(0).getCount(),is(greaterThan(1L)));
}