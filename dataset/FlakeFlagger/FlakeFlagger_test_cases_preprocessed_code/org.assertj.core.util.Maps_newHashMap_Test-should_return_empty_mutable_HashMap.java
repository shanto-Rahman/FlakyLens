@Test public void should_return_empty_mutable_HashMap(){
assertThat(map).isInstanceOf(HashMap.class);
assertThat(map).isEmpty();
assertThat(map).containsExactly(MapEntry.entry("abc",123));
}