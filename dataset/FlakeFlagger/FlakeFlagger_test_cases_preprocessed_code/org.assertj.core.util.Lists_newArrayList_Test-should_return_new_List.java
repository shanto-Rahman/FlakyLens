@Test public void should_return_new_List(){
assertThat(list2).isNotSameAs(list1);
assertThat(list2).isEmpty();
}