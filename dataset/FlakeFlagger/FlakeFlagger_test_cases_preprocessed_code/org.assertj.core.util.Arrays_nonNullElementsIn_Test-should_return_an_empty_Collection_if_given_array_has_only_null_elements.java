@Test public void should_return_an_empty_Collection_if_given_array_has_only_null_elements(){
assertTrue(Arrays.nonNullElementsIn(array).isEmpty());
}