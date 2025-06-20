@Test public void should_return_singleton_instance(){
assertThat(EmptyTextDescription.emptyText()).isSameAs(description);
}