@Test public void shouldInvokeLoadTwoTimesForDifferentKeys() throws Exception {
executor.execute(getRunnableForKey(key1));
executor.execute(getRunnableForKey(key1));
executor.execute(getRunnableForKey(key2));
executor.execute(getRunnableForKey(key1));
executor.execute(getRunnableForKey(key2));
executor.execute(getRunnableForKey(key1));
executor.execute(getRunnableForKey(key2));
executor.execute(getRunnableForKey(key1));
Assert.assertEquals(2,count.get());
}