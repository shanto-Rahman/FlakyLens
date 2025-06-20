@Test public void excludeGroupIdNoMatch() throws ArtifactFilterException {
assertEquals("Should not have been filtered",1,result.size());
assertSame(artifact,result.iterator().next());
}