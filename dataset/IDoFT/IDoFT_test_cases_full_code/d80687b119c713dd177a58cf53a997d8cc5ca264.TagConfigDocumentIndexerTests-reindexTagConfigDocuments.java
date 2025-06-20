@Test public void reindexTagConfigDocuments() throws Exception {
  final String index=Indices.indexFor(new TagConfigDocument());
  DeleteIndexResponse deleteResponse=client.getClient().admin().indices().prepareDelete(index).get();
  assertTrue("The index could not be deleted",deleteResponse.isAcknowledged());
  this.indexer.reindexAllTagConfigDocuments();
  client.getClient().admin().indices().prepareRefresh(index).get();
  client.getClient().admin().cluster().prepareHealth().setIndices(index).setWaitForYellowStatus().get();
  SearchResponse response=client.getClient().prepareSearch(index).get();
  assertEquals("There should be 53 tag config documents",53,response.getHits().totalHits);
}
