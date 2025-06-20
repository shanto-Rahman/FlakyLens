@Test public void should_create_Assert_with_extends(){
Assertions.assertThat(list1).isEqualTo(list2);
Assertions.assertThat(list2).isEqualTo(list1);
}