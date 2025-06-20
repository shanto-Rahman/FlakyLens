@Test public void excludeMulti() throws ArtifactFilterException {
assertEquals("Two dependencies should have been filtered",1,result.size());
assertSame(anotherAcme,result.iterator().next());
}