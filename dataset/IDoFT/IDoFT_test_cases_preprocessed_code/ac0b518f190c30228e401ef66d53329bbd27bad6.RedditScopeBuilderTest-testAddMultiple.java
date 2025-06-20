@Test public void testAddMultiple(){
assertTrue((RedditScope.EDIT.value() + RedditScope.SEPARATOR + RedditScope.FLAIR.value()).equals(builder.build()) || (RedditScope.FLAIR.value() + RedditScope.SEPARATOR + RedditScope.EDIT.value()).equals(builder.build()));
}