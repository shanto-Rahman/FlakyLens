@Test public void should_extract_multiple_values_from_maps_by_keys(){
assertThat(maps).extracting(key1,key2,"bad key").containsExactly(tuple(yoda,luke,null),tuple(yoda,han,null));
}