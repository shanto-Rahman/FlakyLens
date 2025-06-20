@Test public void unorderedShouldOverrideDefault(){
assertSame(victim.getPreProcessors().iterator().next(),UnorderedProcessorProvider.CONFORM_COLORS);
}