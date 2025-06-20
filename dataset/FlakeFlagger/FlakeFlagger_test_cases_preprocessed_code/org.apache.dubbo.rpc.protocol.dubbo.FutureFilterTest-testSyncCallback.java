@Test public void testSyncCallback(){
given(invoker.invoke(invocation)).willReturn(result);//RW
Result filterResult=eventFilter.invoke(invoker,invocation);//RW
assertEquals("High",filterResult.getValue());
}