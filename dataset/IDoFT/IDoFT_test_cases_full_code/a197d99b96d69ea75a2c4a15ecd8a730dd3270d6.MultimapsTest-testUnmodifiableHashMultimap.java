@GwtIncompatible public void testUnmodifiableHashMultimap(){
  checkUnmodifiableMultimap(HashMultimap.<String,Integer>create(),false);
}
