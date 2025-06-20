@Test public void testConvert1() throws IOException {
  MetadataQuerierByFileImpl metadataQuerierByFile=new MetadataQuerierByFileImpl(reader);
  ArrayList<Path> paths=new ArrayList<>();
  paths.add(new Path("d1","s6"));
  paths.add(new Path("d2","s1"));
  long spacePartitionStartPos=d1chunkGroupMetaDataOffsetList.get(0)[0];
  long spacePartitionEndPos=d1chunkGroupMetaDataOffsetList.get(1)[1];
  ArrayList<TimeRange> resTimeRanges=new ArrayList<>(metadataQuerierByFile.convertSpace2TimePartition(paths,spacePartitionStartPos,spacePartitionEndPos));
  ArrayList<TimeRange> unionCandidates=new ArrayList<>();
  unionCandidates.add(d1s6timeRangeList.get(0));
  unionCandidates.add(d2s1timeRangeList.get(0));
  unionCandidates.add(d1s6timeRangeList.get(1));
  ArrayList<TimeRange> expectedRanges=new ArrayList<>(TimeRange.sortAndMerge(unionCandidates));
  Assert.assertEquals(expectedRanges.toString(),resTimeRanges.toString());
}
