@Test public void should_create_comparator_using_fields(){
assertThat(comparator).isNotNull();
assertThat(comparator.getFields()).containsExactly("a","b");
}