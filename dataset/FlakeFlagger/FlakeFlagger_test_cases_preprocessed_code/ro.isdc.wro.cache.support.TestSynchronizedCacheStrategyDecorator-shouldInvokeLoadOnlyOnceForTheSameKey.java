@Test public void shouldInvokeLoadOnlyOnceForTheSameKey() throws Exception {
executor.execute(getRunnableForKey(key));
executor.execute(getRunnableForKey(key));
executor.execute(getRunnableForKey(key));
executor.execute(getRunnableForKey(key));
executor.execute(getRunnableForKey(key));
Assert.assertEquals(1,count.get());
}