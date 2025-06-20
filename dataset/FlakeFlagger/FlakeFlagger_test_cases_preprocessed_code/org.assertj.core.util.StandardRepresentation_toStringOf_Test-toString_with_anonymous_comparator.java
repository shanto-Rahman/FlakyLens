@Test public void toString_with_anonymous_comparator(){
assertEquals("'anonymous comparator class'",new StandardRepresentation().toStringOf(anonymousComparator));
}