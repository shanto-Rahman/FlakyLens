@Test public void should_return_new_HashSet(){
assertThat(set2).isNotSameAs(set1);
assertThat(set2).isEmpty();
}