@Test public void everySearchTypeGeneratesOneESQuery() throws Exception {
assertThat(generatedRequest).isEqualTo(resourceFile("everySearchTypeGeneratesOneESQuery.request.ndjson"));
}