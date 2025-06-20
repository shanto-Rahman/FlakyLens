@Test @SuppressWarnings("unchecked") public void iterableOfEnumeration(){
assertThat(iterable).isNotNull();
assertThat(set).containsExactly(1,2,3);
}