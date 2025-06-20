@Test public void testGetPublicProjectOnly() throws Throwable {
assertEquals(Long.valueOf(2),getResult.documentCount);
assertEquals(2,getResult.documentLinks.size());
assertEquals(2,getResult.documents.size());
assertTrue(getResult.documentLinks.contains(testProject1.documentSelfLink));
assertTrue(getResult.documentLinks.contains(testProject2.documentSelfLink));
assertTrue(!getResult.documentLinks.contains(testProject3.documentSelfLink));
assertTrue(!getResult.documentLinks.contains(testProject4.documentSelfLink));
}