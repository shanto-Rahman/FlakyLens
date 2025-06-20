@Test public void should_return_empty_mutable_Set(){
assertThat(set).isEmpty();
assertThat(set).containsExactly("element");
}