@Test public void testChartIndexPassedCorrectly() throws Exception {
  ArgumentCaptor<ChartIndex> captor=ArgumentCaptor.forClass(ChartIndex.class);
  TempBlob tempBlob=underTest.build(index,storageFacet);
  verify(yamlParser).write(any(OutputStream.class),captor.capture());
  assertEquals(index,captor.getValue());
}
