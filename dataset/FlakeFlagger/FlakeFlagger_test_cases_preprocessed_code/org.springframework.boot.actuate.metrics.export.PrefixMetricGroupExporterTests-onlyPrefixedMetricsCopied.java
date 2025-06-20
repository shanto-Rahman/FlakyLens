@Test public void onlyPrefixedMetricsCopied(){
assertEquals(1,Iterables.collection(this.writer.groups()).size());
}