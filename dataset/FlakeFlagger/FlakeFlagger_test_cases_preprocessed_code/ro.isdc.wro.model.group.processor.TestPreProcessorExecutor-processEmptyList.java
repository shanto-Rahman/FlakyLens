@Test public void processEmptyList() throws Exception {
Assert.assertEquals("",victim.processAndMerge(resources,true));
Assert.assertEquals("",victim.processAndMerge(resources,false));
}