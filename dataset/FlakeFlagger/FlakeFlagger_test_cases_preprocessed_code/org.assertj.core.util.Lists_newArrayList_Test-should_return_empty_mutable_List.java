@Test public void should_return_empty_mutable_List(){
assertThat(list).isEmpty();
assertThat(list).containsExactly("abc");
}