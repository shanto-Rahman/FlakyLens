@Test public void should_extract_single_value_from_maps_by_key(){
assertThat(maps).extracting(key2).containsExactly(luke,han);
assertThat(maps).extracting(key2,Employee.class).containsExactly(luke,han);
assertThat(maps).extracting(key1).containsExactly(yoda,yoda);
assertThat(maps).extracting("bad key").containsExactly(null,null);
}