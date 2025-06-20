@Test public void should_create_error_message(){
assertThat(message).isEqualTo("[Test] \nsome elements are not mutually comparable according to 'CaseInsensitiveStringComparator' comparator in group:\n" + "<[\"b\", \"c\", \"a\"]>");
}