@Test public void should_return_empty_List_if_given_Iterable_has_only_null_elements(){
assertTrue(Iterables.nonNullElementsIn(c).isEmpty());
}