@Test public void should_return_new_HashMap(){
assertThat(map2).isNotSameAs(map1);
assertThat(map2).isEmpty();
}