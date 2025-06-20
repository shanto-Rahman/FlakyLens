@Test public void reindexTagConfigDocuments() throws Exception {
assertTrue("The index could not be deleted",deleteResponse.isAcknowledged());
assertEquals("There should be 53 tag config documents",53,response.getHits().totalHits);
}