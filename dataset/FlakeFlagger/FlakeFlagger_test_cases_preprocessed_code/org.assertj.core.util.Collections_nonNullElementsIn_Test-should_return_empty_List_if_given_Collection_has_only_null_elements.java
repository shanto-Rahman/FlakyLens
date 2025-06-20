@Test public void should_return_empty_List_if_given_Collection_has_only_null_elements(){
assertTrue(Collections.nonNullElementsIn(c).isEmpty());
}