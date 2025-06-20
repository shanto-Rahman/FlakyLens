@Test public void should_return_toString_of_Collection_of_arrays(){
assertEquals("[[true, false], [true, false, true]]",new StandardRepresentation().toStringOf(collection));
}