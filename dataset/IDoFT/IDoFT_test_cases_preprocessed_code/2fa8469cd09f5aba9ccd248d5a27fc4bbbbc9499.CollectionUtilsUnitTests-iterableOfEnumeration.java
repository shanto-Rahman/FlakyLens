@Test @SuppressWarnings("unchecked") public void iterableOfEnumeration(){
assertThat(iterable).isNotNull();
assertThat(StreamSupport.stream(iterable.spliterator(),false).collect(Collectors.toSet())).containsExactly(1,2,3);
}