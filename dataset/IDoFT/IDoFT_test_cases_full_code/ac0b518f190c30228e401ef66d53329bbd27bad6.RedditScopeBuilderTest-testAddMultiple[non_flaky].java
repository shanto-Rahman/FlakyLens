@Test public void testAddMultiple(){
  builder.addScopes(RedditScope.EDIT,RedditScope.FLAIR);
  String s=builder.build();
  assertTrue((RedditScope.EDIT.value() + RedditScope.SEPARATOR + RedditScope.FLAIR.value()).equals(s) || (RedditScope.FLAIR.value() + RedditScope.SEPARATOR + RedditScope.EDIT.value()).equals(s));
  builder.removeScopes(RedditScope.EDIT,RedditScope.FLAIR);
}
