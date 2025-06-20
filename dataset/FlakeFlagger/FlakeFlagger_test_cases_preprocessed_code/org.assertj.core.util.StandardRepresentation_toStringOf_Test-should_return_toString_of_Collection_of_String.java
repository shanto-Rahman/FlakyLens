@Test public void should_return_toString_of_Collection_of_String(){
assertEquals("[\"s1\", \"s2\"]",new StandardRepresentation().toStringOf(collection));
}