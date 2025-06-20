@Test public void should_create_Assert_with_list_extended(){
Assertions.assertThat(strings0).isEqualTo(strings1);
Assertions.assertThat(strings1).isEqualTo(strings0);
}