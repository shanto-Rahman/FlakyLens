@Test public void testAddMultiple(){
assertTrue((RedditScope.EDIT.value() + RedditScope.SEPARATOR + RedditScope.FLAIR.value()).equals(s) || (RedditScope.FLAIR.value() + RedditScope.SEPARATOR + RedditScope.EDIT.value()).equals(s));
}