@Test public void should_return_toString_of_Collection_of_Collections(){
assertEquals("[[\"s1\", \"s2\"], [\"s3\", \"s4\", \"s5\"]]",new StandardRepresentation().toStringOf(collection));
}