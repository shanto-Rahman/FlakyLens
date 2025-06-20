@Test @SuppressWarnings("unchecked") public void iterableOfIterator(){
assertThat(iterable).isNotNull();
assertThat(set).hasSize(3);
assertThat(set).containsExactly(1,2,3);
}