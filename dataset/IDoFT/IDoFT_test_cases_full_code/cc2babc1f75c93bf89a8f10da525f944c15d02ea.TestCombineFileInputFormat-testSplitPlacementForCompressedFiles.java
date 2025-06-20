/** 
 * The test suppresses unchecked warnings in {@link org.mockito.Mockito#reset}. Although calling the method is a bad manner, we call the method instead of splitting the test (i.e. restarting MiniDFSCluster) to save time.
 */
@Test @SuppressWarnings("unchecked") public void testSplitPlacementForCompressedFiles() throws Exception {
  MiniDFSCluster dfs=null;
  FileSystem fileSys=null;
  try {
    Configuration conf=new Configuration();
    conf.setBoolean("dfs.replication.considerLoad",false);
    dfs=new MiniDFSCluster.Builder(conf).racks(rack1).hosts(hosts1).build();
    dfs.waitActive();
    fileSys=dfs.getFileSystem();
    if (!fileSys.mkdirs(inDir)) {
      throw new IOException("Mkdirs failed to create " + inDir.toString());
    }
    Path file1=new Path(dir1 + "/file1.gz");
    FileStatus f1=writeGzipFile(conf,file1,(short)1,1);
    Path file5=new Path(dir5 + "/file5.gz");
    FileStatus f5=writeGzipFile(conf,file5,(short)1,1);
    DummyInputFormat inFormat=new DummyInputFormat();
    Job job=Job.getInstance(conf);
    FileInputFormat.setInputPaths(job,dir1 + "," + dir5);
    List<InputSplit> splits=inFormat.getSplits(job);
    System.out.println("Made splits(Test0): " + splits.size());
    for (    InputSplit split : splits) {
      System.out.println("File split(Test0): " + split);
    }
    assertEquals(1,splits.size());
    CombineFileSplit fileSplit=(CombineFileSplit)splits.get(0);
    assertEquals(2,fileSplit.getNumPaths());
    assertEquals(1,fileSplit.getLocations().length);
    assertEquals(file1.getName(),fileSplit.getPath(0).getName());
    assertEquals(0,fileSplit.getOffset(0));
    assertEquals(f1.getLen(),fileSplit.getLength(0));
    assertEquals(file5.getName(),fileSplit.getPath(1).getName());
    assertEquals(0,fileSplit.getOffset(1));
    assertEquals(f5.getLen(),fileSplit.getLength(1));
    assertEquals(hosts1[0],fileSplit.getLocations()[0]);
    dfs.startDataNodes(conf,1,true,null,rack2,hosts2,null);
    dfs.waitActive();
    Path file2=new Path(dir2 + "/file2.gz");
    FileStatus f2=writeGzipFile(conf,file2,(short)2,2);
    inFormat=new DummyInputFormat();
    FileInputFormat.setInputPaths(job,dir1 + "," + dir2);
    inFormat.setMinSplitSizeRack(f1.getLen());
    splits=inFormat.getSplits(job);
    System.out.println("Made splits(Test1): " + splits.size());
    for (    InputSplit split : splits) {
      System.out.println("File split(Test1): " + split);
    }
    Set<Split> expected=new HashSet<>();
    expected.add(new Split(file1.getName(),f1.getLen(),0));
    expected.add(new Split(file2.getName(),f2.getLen(),0));
    List<Split> actual=new ArrayList<>();
    for (    InputSplit split : splits) {
      fileSplit=(CombineFileSplit)split;
      if (splits.size() == 2) {
        if (split.equals(splits.get(0))) {
          assertEquals(1,fileSplit.getNumPaths());
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(file2.getName(),fileSplit.getPath(0).getName());
          assertEquals(0,fileSplit.getOffset(0));
          assertEquals(f2.getLen(),fileSplit.getLength(0));
          assertEquals(hosts2[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(1))) {
          assertEquals(1,fileSplit.getNumPaths());
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(file1.getName(),fileSplit.getPath(0).getName());
          assertEquals(0,fileSplit.getOffset(0));
          assertEquals(f1.getLen(),fileSplit.getLength(0));
          assertEquals(hosts1[0],fileSplit.getLocations()[0]);
        }
      }
 else       if (splits.size() == 1) {
        assertEquals(2,fileSplit.getNumPaths());
        assertEquals(1,fileSplit.getLocations().length);
        assertEquals(hosts1[0],fileSplit.getLocations()[0]);
      }
 else {
        fail("Split size should be 1 or 2.");
      }
      for (int i=0; i < fileSplit.getNumPaths(); i++) {
        String name=fileSplit.getPath(i).getName();
        long length=fileSplit.getLength(i);
        long offset=fileSplit.getOffset(i);
        actual.add(new Split(name,length,offset));
      }
    }
    assertEquals(2,actual.size());
    assertTrue(actual.containsAll(expected));
    dfs.startDataNodes(conf,1,true,null,rack3,hosts3,null);
    dfs.waitActive();
    Path file3=new Path(dir3 + "/file3.gz");
    FileStatus f3=writeGzipFile(conf,file3,(short)3,3);
    inFormat=new DummyInputFormat();
    FileInputFormat.setInputPaths(job,dir1 + "," + dir2+ ","+ dir3);
    inFormat.setMinSplitSizeRack(f1.getLen());
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test2): " + split);
    }
    expected.add(new Split(file3.getName(),f3.getLen(),0));
    actual.clear();
    for (    InputSplit split : splits) {
      fileSplit=(CombineFileSplit)split;
      if (splits.size() == 3) {
        if (split.equals(splits.get(0))) {
          assertEquals(1,fileSplit.getNumPaths());
          assertEquals(file3.getName(),fileSplit.getPath(0).getName());
          assertEquals(f3.getLen(),fileSplit.getLength(0));
          assertEquals(0,fileSplit.getOffset(0));
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts3[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(1))) {
          assertEquals(1,fileSplit.getNumPaths());
          assertEquals(file2.getName(),fileSplit.getPath(0).getName());
          assertEquals(f2.getLen(),fileSplit.getLength(0));
          assertEquals(0,fileSplit.getOffset(0));
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts2[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(2))) {
          assertEquals(1,fileSplit.getNumPaths());
          assertEquals(file1.getName(),fileSplit.getPath(0).getName());
          assertEquals(f1.getLen(),fileSplit.getLength(0));
          assertEquals(0,fileSplit.getOffset(0));
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts1[0],fileSplit.getLocations()[0]);
        }
      }
 else       if (splits.size() == 2) {
        if (split.equals(splits.get(0))) {
          assertEquals(1,fileSplit.getLocations().length);
          if (fileSplit.getLocations()[0].equals(hosts2[0])) {
            assertEquals(2,fileSplit.getNumPaths());
          }
 else           if (fileSplit.getLocations()[0].equals(hosts3[0])) {
            assertEquals(1,fileSplit.getNumPaths());
          }
 else {
            fail("First split should be on rack2 or rack3.");
          }
        }
        if (split.equals(splits.get(1))) {
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts1[0],fileSplit.getLocations()[0]);
        }
      }
 else       if (splits.size() == 1) {
        assertEquals(1,fileSplit.getLocations().length);
        assertEquals(3,fileSplit.getNumPaths());
        assertEquals(hosts1[0],fileSplit.getLocations()[0]);
      }
 else {
        fail("Split size should be 1, 2, or 3.");
      }
      for (int i=0; i < fileSplit.getNumPaths(); i++) {
        String name=fileSplit.getPath(i).getName();
        long length=fileSplit.getLength(i);
        long offset=fileSplit.getOffset(i);
        actual.add(new Split(name,length,offset));
      }
    }
    assertEquals(3,actual.size());
    assertTrue(actual.containsAll(expected));
    Path file4=new Path(dir4 + "/file4.gz");
    FileStatus f4=writeGzipFile(conf,file4,(short)3,3);
    inFormat=new DummyInputFormat();
    FileInputFormat.setInputPaths(job,dir1 + "," + dir2+ ","+ dir3+ ","+ dir4);
    inFormat.setMinSplitSizeRack(f1.getLen());
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test3): " + split);
    }
    expected.add(new Split(file3.getName(),f3.getLen(),0));
    actual.clear();
    for (    InputSplit split : splits) {
      fileSplit=(CombineFileSplit)split;
      if (splits.size() == 3) {
        if (split.equals(splits.get(0))) {
          assertEquals(2,fileSplit.getNumPaths());
          assertEquals(hosts3[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(1))) {
          assertEquals(1,fileSplit.getNumPaths());
          assertEquals(file2.getName(),fileSplit.getPath(0).getName());
          assertEquals(f2.getLen(),fileSplit.getLength(0));
          assertEquals(0,fileSplit.getOffset(0));
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts2[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(2))) {
          assertEquals(1,fileSplit.getNumPaths());
          assertEquals(file1.getName(),fileSplit.getPath(0).getName());
          assertEquals(f1.getLen(),fileSplit.getLength(0));
          assertEquals(0,fileSplit.getOffset(0));
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts1[0],fileSplit.getLocations()[0]);
        }
      }
 else       if (splits.size() == 2) {
        if (split.equals(splits.get(0))) {
          assertEquals(1,fileSplit.getLocations().length);
          if (fileSplit.getLocations()[0].equals(hosts2[0])) {
            assertEquals(3,fileSplit.getNumPaths());
          }
 else           if (fileSplit.getLocations()[0].equals(hosts3[0])) {
            assertEquals(2,fileSplit.getNumPaths());
          }
 else {
            fail("First split should be on rack2 or rack3.");
          }
        }
        if (split.equals(splits.get(1))) {
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts1[0],fileSplit.getLocations()[0]);
        }
      }
 else       if (splits.size() == 1) {
        assertEquals(1,fileSplit.getLocations().length);
        assertEquals(4,fileSplit.getNumPaths());
        assertEquals(hosts1[0],fileSplit.getLocations()[0]);
      }
 else {
        fail("Split size should be 1, 2, or 3.");
      }
      for (int i=0; i < fileSplit.getNumPaths(); i++) {
        String name=fileSplit.getPath(i).getName();
        long length=fileSplit.getLength(i);
        long offset=fileSplit.getOffset(i);
        actual.add(new Split(name,length,offset));
      }
    }
    assertEquals(4,actual.size());
    assertTrue(actual.containsAll(expected));
    inFormat=new DummyInputFormat();
    inFormat.setMinSplitSizeNode(f1.getLen());
    inFormat.setMaxSplitSize(f1.getLen());
    FileInputFormat.setInputPaths(job,dir1 + "," + dir2+ ","+ dir3+ ","+ dir4);
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test4): " + split);
    }
    assertEquals(4,splits.size());
    actual.clear();
    for (    InputSplit split : splits) {
      fileSplit=(CombineFileSplit)split;
      for (int i=0; i < fileSplit.getNumPaths(); i++) {
        String name=fileSplit.getPath(i).getName();
        long length=fileSplit.getLength(i);
        long offset=fileSplit.getOffset(i);
        actual.add(new Split(name,length,offset));
      }
      mockList.add(fileSplit.getLocations()[0]);
    }
    assertEquals(4,actual.size());
    assertTrue(actual.containsAll(expected));
    verify(mockList,atLeastOnce()).add(hosts1[0]);
    verify(mockList,atLeastOnce()).add(hosts2[0]);
    verify(mockList,atLeastOnce()).add(hosts3[0]);
    inFormat=new DummyInputFormat();
    inFormat.setMinSplitSizeNode(f1.getLen());
    inFormat.setMaxSplitSize(2 * f1.getLen());
    FileInputFormat.setInputPaths(job,dir1 + "," + dir2+ ","+ dir3+ ","+ dir4);
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test5): " + split);
    }
    actual.clear();
    reset(mockList);
    for (    InputSplit split : splits) {
      fileSplit=(CombineFileSplit)split;
      for (int i=0; i < fileSplit.getNumPaths(); i++) {
        String name=fileSplit.getPath(i).getName();
        long length=fileSplit.getLength(i);
        long offset=fileSplit.getOffset(i);
        actual.add(new Split(name,length,offset));
      }
      mockList.add(fileSplit.getLocations()[0]);
    }
    assertEquals(4,actual.size());
    assertTrue(actual.containsAll(expected));
    if (splits.size() == 3) {
      verify(mockList,times(1)).add(hosts1[0]);
      verify(mockList,times(1)).add(hosts2[0]);
      verify(mockList,times(1)).add(hosts3[0]);
    }
 else     if (splits.size() == 2) {
      verify(mockList,times(1)).add(hosts1[0]);
    }
 else {
      fail("Split size should be 2 or 3.");
    }
    inFormat=new DummyInputFormat();
    inFormat.setMinSplitSizeNode(2 * f1.getLen());
    inFormat.setMaxSplitSize(4 * f1.getLen());
    FileInputFormat.setInputPaths(job,dir1 + "," + dir2+ ","+ dir3+ ","+ dir4);
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test6): " + split);
    }
    assertTrue("Split size should be 1 or 2.",splits.size() == 1 || splits.size() == 2);
    actual.clear();
    reset(mockList);
    for (    InputSplit split : splits) {
      fileSplit=(CombineFileSplit)split;
      for (int i=0; i < fileSplit.getNumPaths(); i++) {
        String name=fileSplit.getPath(i).getName();
        long length=fileSplit.getLength(i);
        long offset=fileSplit.getOffset(i);
        actual.add(new Split(name,length,offset));
      }
      mockList.add(fileSplit.getLocations()[0]);
    }
    assertEquals(4,actual.size());
    assertTrue(actual.containsAll(expected));
    verify(mockList,times(1)).add(hosts1[0]);
    inFormat=new DummyInputFormat();
    inFormat.setMaxSplitSize(4 * f1.getLen());
    inFormat.setMinSplitSizeRack(4 * f1.getLen());
    FileInputFormat.setInputPaths(job,dir1 + "," + dir2+ ","+ dir3+ ","+ dir4);
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test7): " + split);
    }
    assertEquals(1,splits.size());
    fileSplit=(CombineFileSplit)splits.get(0);
    assertEquals(4,fileSplit.getNumPaths());
    assertEquals(1,fileSplit.getLocations().length);
    assertEquals(hosts1[0],fileSplit.getLocations()[0]);
    inFormat=new DummyInputFormat();
    inFormat.setMinSplitSizeNode(4 * f1.getLen());
    FileInputFormat.setInputPaths(job,dir1 + "," + dir2+ ","+ dir3+ ","+ dir4);
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test8): " + split);
    }
    assertEquals(1,splits.size());
    fileSplit=(CombineFileSplit)splits.get(0);
    assertEquals(4,fileSplit.getNumPaths());
    assertEquals(1,fileSplit.getLocations().length);
    assertEquals(hosts1[0],fileSplit.getLocations()[0]);
    inFormat=new DummyInputFormat();
    FileInputFormat.addInputPath(job,inDir);
    inFormat.setMinSplitSizeRack(1);
    inFormat.createPool(new TestFilter(dir1),new TestFilter(dir2));
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test9): " + split);
    }
    actual.clear();
    for (    InputSplit split : splits) {
      fileSplit=(CombineFileSplit)split;
      if (splits.size() == 3) {
        if (split.equals(splits.get(0))) {
          assertEquals(1,fileSplit.getNumPaths());
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts2[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(1))) {
          assertEquals(1,fileSplit.getNumPaths());
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts1[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(2))) {
          assertEquals(2,fileSplit.getNumPaths());
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts3[0],fileSplit.getLocations()[0]);
        }
      }
 else       if (splits.size() == 2) {
        if (split.equals(splits.get(0))) {
          assertEquals(2,fileSplit.getNumPaths());
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts1[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(1))) {
          assertEquals(2,fileSplit.getNumPaths());
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts3[0],fileSplit.getLocations()[0]);
        }
      }
 else {
        fail("Split size should be 2 or 3.");
      }
      for (int i=0; i < fileSplit.getNumPaths(); i++) {
        String name=fileSplit.getPath(i).getName();
        long length=fileSplit.getLength(i);
        long offset=fileSplit.getOffset(i);
        actual.add(new Split(name,length,offset));
      }
    }
    assertEquals(4,actual.size());
    assertTrue(actual.containsAll(expected));
    int numPools=100;
    int numFiles=1000;
    DummyInputFormat1 inFormat1=new DummyInputFormat1();
    for (int i=0; i < numFiles; i++) {
      FileInputFormat.setInputPaths(job,file1);
    }
    inFormat1.setMinSplitSizeRack(1);
    final Path dirNoMatch1=new Path(inDir,"/dirxx");
    final Path dirNoMatch2=new Path(inDir,"/diryy");
    for (int i=0; i < numPools; i++) {
      inFormat1.createPool(new TestFilter(dirNoMatch1),new TestFilter(dirNoMatch2));
    }
    long start=System.currentTimeMillis();
    splits=inFormat1.getSplits(job);
    long end=System.currentTimeMillis();
    System.out.println("Elapsed time for " + numPools + " pools "+ " and "+ numFiles+ " files is "+ ((end - start))+ " milli seconds.");
  }
  finally {
    if (dfs != null) {
      dfs.shutdown();
    }
  }
}
