@Test void scanShouldIterateOverAvailableEntries(){
assertThat(iterator.next()).isEqualTo(new AbstractMap.SimpleEntry<>("1",object1));
assertThat(iterator.next()).isEqualTo(new AbstractMap.SimpleEntry<>("2",object2));
assertThat(iterator.hasNext()).isFalse();
}