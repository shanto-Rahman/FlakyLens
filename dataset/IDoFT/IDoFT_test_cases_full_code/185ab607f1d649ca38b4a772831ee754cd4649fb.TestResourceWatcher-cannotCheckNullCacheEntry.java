@Test(expected=NullPointerException.class) public void cannotCheckNullCacheEntry(){
  Context.unset();
  victim.check(null);
}
