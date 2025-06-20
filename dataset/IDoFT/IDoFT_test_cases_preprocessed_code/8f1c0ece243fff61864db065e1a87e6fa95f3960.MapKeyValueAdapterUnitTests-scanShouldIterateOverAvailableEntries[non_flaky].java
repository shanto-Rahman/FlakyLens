@Test void scanShouldIterateOverAvailableEntries(){
if (entry1.getKey().equals("1")) {
assertThat(entry1).isEqualTo(new AbstractMap.SimpleEntry<>("1",object1));
assertThat(entry2).isEqualTo(new AbstractMap.SimpleEntry<>("2",object2));
assertThat(entry2).isEqualTo(new AbstractMap.SimpleEntry<>("2",object2));
assertThat(entry1).isEqualTo(new AbstractMap.SimpleEntry<>("1",object1));
}
assertThat(iterator.hasNext()).isFalse();
}