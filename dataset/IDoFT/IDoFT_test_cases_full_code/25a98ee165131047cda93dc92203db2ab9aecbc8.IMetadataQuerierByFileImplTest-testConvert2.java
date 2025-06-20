@Test public void testConvert2() throws IOException {
  MetadataQuerierByFileImpl metadataQuerierByFile=new MetadataQuerierByFileImpl(reader);
  ArrayList<Path> paths=new ArrayList<>();
  paths.add(new Path("d1","s6"));
  paths.add(new Path("d2","s1"));
  long spacePartitionStartPos=d2chunkGroupMetaDataOffsetList.get(0)[0];
  long spacePartitionEndPos=d2chunkGroupMetaDataOffsetList.get(0)[1];
  ArrayList<TimeRange> inCandidates=new ArrayList<>();
  ArrayList<TimeRange> beforeCandidates=new ArrayList<>();
  ArrayList<TimeRange> resTimeRanges=new ArrayList<>(metadataQuerierByFile.convertSpace2TimePartition(paths,spacePartitionStartPos,spacePartitionEndPos));
  inCandidates.add(d2s1timeRangeList.get(0));
  beforeCandidates.add(d1s6timeRangeList.get(0));
  ArrayList<TimeRange> expectedRanges=new ArrayList<>();
  for (  TimeRange in : inCandidates) {
    ArrayList<TimeRange> remains=new ArrayList<>(in.getRemains(beforeCandidates));
    expectedRanges.addAll(remains);
  }
  Assert.assertEquals(expectedRanges.toString(),resTimeRanges.toString());
}
