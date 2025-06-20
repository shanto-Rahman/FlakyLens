@Test public void queryUsesOnlyIndicesIncludingTimerangeAndStream() throws Exception {
  final String streamId="streamId";
  final Stream stream=mock(Stream.class,RETURNS_DEEP_STUBS);
  when(stream.getId()).thenReturn(streamId);
  when(streamService.load(streamId)).thenReturn(stream);
  final IndexRange indexRange1=mock(IndexRange.class);
  when(indexRange1.indexName()).thenReturn("index1");
  when(indexRange1.streamIds()).thenReturn(Collections.singletonList(streamId));
  final IndexRange indexRange2=mock(IndexRange.class);
  when(indexRange2.indexName()).thenReturn("index2");
  when(indexRange2.streamIds()).thenReturn(Collections.singletonList(streamId));
  final IndexRange indexRange3=mock(IndexRange.class);
  when(indexRange3.indexName()).thenReturn("index3");
  when(indexRange3.streamIds()).thenReturn(Collections.emptyList());
  final SortedSet<IndexRange> indexRanges=sortedSetOf(indexRange1,indexRange2,indexRange3);
  when(indexRangeService.find(any(DateTime.class),any(DateTime.class))).thenReturn(indexRanges);
  final Query query=dummyQuery(RelativeRange.create(600)).toBuilder().filter(StreamFilter.ofId(streamId)).build();
  final Search search=dummySearch(query);
  final SearchJob job=new SearchJob("job1",search,"admin");
  final ESGeneratedQueryContext context=backend.generate(job,query,Collections.emptySet());
  backend.doRun(job,query,context,Collections.emptySet());
  verify(jestClient,times(1)).execute(clientRequestCaptor.capture(),any());
  final MultiSearch clientRequest=clientRequestCaptor.getValue();
  assertThat(clientRequest).isNotNull();
  assertThat(indicesOf(clientRequest).get(0)).isEqualTo("index1,index2");
}
