@Test public void should_return_null_elements_for_null_field_value(){
assertThat(ages).containsExactly(null,null);
assertThat(names).containsExactly(new Name("Yoda"),null,null,null);
assertThat(firstNames).containsExactly("Yoda",null,null,null);
}