@Test public void should_return_null_if_Iterable_is_null(){
assertThat(Sets.newHashSet(iterable)).isNull();
}