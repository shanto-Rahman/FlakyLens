@Test public void should_return_empty_mutable_ConcurrentHashMap(){
assertThat(map).isInstanceOf(ConcurrentHashMap.class);
assertThat(map).isEmpty();
assertThat(map).containsExactly(MapEntry.entry("abc",123));
}