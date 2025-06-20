@GwtIncompatible public void testUnmodifiableSynchronizedHashMultimap(){
  checkUnmodifiableMultimap(Multimaps.synchronizedSetMultimap(HashMultimap.<String,Integer>create()),false);
}
