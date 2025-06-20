@Test public void orderedShouldOverrideUnordered(){
assertSame(victim.getPreProcessors().iterator().next(),OrderedProcessorProvider.CUSTOM);
}