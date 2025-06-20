@Test void scanShouldIterateOverAvailableEntries(){
  adapter.put("1",object1,COLLECTION_1);
  adapter.put("2",object2,COLLECTION_1);
  CloseableIterator<Map.Entry<Object,Object>> iterator=adapter.entries(COLLECTION_1);
  Map.Entry<Object,Object> entry1=iterator.next();
  Map.Entry<Object,Object> entry2=iterator.next();
  if (entry1.getKey().equals("1")) {
    assertThat(entry1).isEqualTo(new AbstractMap.SimpleEntry<>("1",object1));
    assertThat(entry2).isEqualTo(new AbstractMap.SimpleEntry<>("2",object2));
  }
 else {
    assertThat(entry2).isEqualTo(new AbstractMap.SimpleEntry<>("2",object2));
    assertThat(entry1).isEqualTo(new AbstractMap.SimpleEntry<>("1",object1));
  }
  assertThat(iterator.hasNext()).isFalse();
}
