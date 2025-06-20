@Test public void should_return_empty_mutable_WeakHashMap(){
assertThat(map).isInstanceOf(WeakHashMap.class);
assertThat(map).isEmpty();
assertThat(map).containsExactly(MapEntry.entry("abc",123));
}