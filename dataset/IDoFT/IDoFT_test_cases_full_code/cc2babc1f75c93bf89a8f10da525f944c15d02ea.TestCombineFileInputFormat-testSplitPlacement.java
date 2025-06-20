/** 
 * The test suppresses unchecked warnings in {@link org.mockito.Mockito#reset}. Although calling the method is a bad manner, we call the method instead of splitting the test (i.e. restarting MiniDFSCluster) to save time.
 */
@Test @SuppressWarnings("unchecked") public void testSplitPlacement() throws Exception {
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
    Path file1=new Path(dir1 + "/file1");
    writeFile(conf,file1,(short)1,1);
    Path file5=new Path(dir5 + "/file5");
    writeFile(conf,file5,(short)1,1);
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
    assertEquals(BLOCKSIZE,fileSplit.getLength(0));
    assertEquals(file5.getName(),fileSplit.getPath(1).getName());
    assertEquals(0,fileSplit.getOffset(1));
    assertEquals(BLOCKSIZE,fileSplit.getLength(1));
    assertEquals(hosts1[0],fileSplit.getLocations()[0]);
    dfs.startDataNodes(conf,1,true,null,rack2,hosts2,null);
    dfs.waitActive();
    Path file2=new Path(dir2 + "/file2");
    writeFile(conf,file2,(short)2,2);
    inFormat=new DummyInputFormat();
    FileInputFormat.setInputPaths(job,dir1 + "," + dir2);
    inFormat.setMinSplitSizeRack(BLOCKSIZE);
    splits=inFormat.getSplits(job);
    System.out.println("Made splits(Test1): " + splits.size());
    for (    InputSplit split : splits) {
      System.out.println("File split(Test1): " + split);
    }
    for (    InputSplit split : splits) {
      fileSplit=(CombineFileSplit)split;
      if (splits.size() == 2) {
        if (split.equals(splits.get(0))) {
          assertEquals(2,fileSplit.getNumPaths());
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(file2.getName(),fileSplit.getPath(0).getName());
          assertEquals(0,fileSplit.getOffset(0));
          assertEquals(BLOCKSIZE,fileSplit.getLength(0));
          assertEquals(file2.getName(),fileSplit.getPath(1).getName());
          assertEquals(BLOCKSIZE,fileSplit.getOffset(1));
          assertEquals(BLOCKSIZE,fileSplit.getLength(1));
          assertEquals(hosts2[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(1))) {
          assertEquals(1,fileSplit.getNumPaths());
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(file1.getName(),fileSplit.getPath(0).getName());
          assertEquals(0,fileSplit.getOffset(0));
          assertEquals(BLOCKSIZE,fileSplit.getLength(0));
          assertEquals(hosts1[0],fileSplit.getLocations()[0]);
        }
      }
 else       if (splits.size() == 1) {
        assertEquals(3,fileSplit.getNumPaths());
        Set<Split> expected=new HashSet<>();
        expected.add(new Split(file1.getName(),BLOCKSIZE,0));
        expected.add(new Split(file2.getName(),BLOCKSIZE,0));
        expected.add(new Split(file2.getName(),BLOCKSIZE,BLOCKSIZE));
        List<Split> actual=new ArrayList<>();
        for (int i=0; i < 3; i++) {
          String name=fileSplit.getPath(i).getName();
          long length=fileSplit.getLength(i);
          long offset=fileSplit.getOffset(i);
          actual.add(new Split(name,length,offset));
        }
        assertTrue(actual.containsAll(expected));
        assertEquals(1,fileSplit.getLocations().length);
        assertEquals(hosts1[0],fileSplit.getLocations()[0]);
      }
 else {
        fail("Expected split size is 1 or 2, but actual size is " + splits.size());
      }
    }
    dfs.startDataNodes(conf,1,true,null,rack3,hosts3,null);
    dfs.waitActive();
    Path file3=new Path(dir3 + "/file3");
    writeFile(conf,new Path(dir3 + "/file3"),(short)3,3);
    inFormat=new DummyInputFormat();
    FileInputFormat.setInputPaths(job,dir1 + "," + dir2+ ","+ dir3);
    inFormat.setMinSplitSizeRack(BLOCKSIZE);
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test2): " + split);
    }
    Set<Split> expected=new HashSet<>();
    expected.add(new Split(file1.getName(),BLOCKSIZE,0));
    expected.add(new Split(file2.getName(),BLOCKSIZE,0));
    expected.add(new Split(file2.getName(),BLOCKSIZE,BLOCKSIZE));
    expected.add(new Split(file3.getName(),BLOCKSIZE,0));
    expected.add(new Split(file3.getName(),BLOCKSIZE,BLOCKSIZE));
    expected.add(new Split(file3.getName(),BLOCKSIZE,BLOCKSIZE * 2));
    List<Split> actual=new ArrayList<>();
    for (    InputSplit split : splits) {
      fileSplit=(CombineFileSplit)split;
      if (splits.size() == 3) {
        if (split.equals(splits.get(0))) {
          assertEquals(3,fileSplit.getNumPaths());
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(file3.getName(),fileSplit.getPath(0).getName());
          assertEquals(0,fileSplit.getOffset(0));
          assertEquals(BLOCKSIZE,fileSplit.getLength(0));
          assertEquals(file3.getName(),fileSplit.getPath(1).getName());
          assertEquals(BLOCKSIZE,fileSplit.getOffset(1));
          assertEquals(BLOCKSIZE,fileSplit.getLength(1));
          assertEquals(file3.getName(),fileSplit.getPath(2).getName());
          assertEquals(2 * BLOCKSIZE,fileSplit.getOffset(2));
          assertEquals(BLOCKSIZE,fileSplit.getLength(2));
          assertEquals(hosts3[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(1))) {
          assertEquals(2,fileSplit.getNumPaths());
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(file2.getName(),fileSplit.getPath(0).getName());
          assertEquals(0,fileSplit.getOffset(0));
          assertEquals(BLOCKSIZE,fileSplit.getLength(0));
          assertEquals(file2.getName(),fileSplit.getPath(1).getName());
          assertEquals(BLOCKSIZE,fileSplit.getOffset(1));
          assertEquals(BLOCKSIZE,fileSplit.getLength(1));
          assertEquals(hosts2[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(2))) {
          assertEquals(1,fileSplit.getNumPaths());
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(file1.getName(),fileSplit.getPath(0).getName());
          assertEquals(0,fileSplit.getOffset(0));
          assertEquals(BLOCKSIZE,fileSplit.getLength(0));
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
            assertEquals(3,fileSplit.getNumPaths());
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
        assertEquals(6,fileSplit.getNumPaths());
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
    assertEquals(6,actual.size());
    assertTrue(actual.containsAll(expected));
    Path file4=new Path(dir4 + "/file4");
    writeFile(conf,file4,(short)3,3);
    inFormat=new DummyInputFormat();
    FileInputFormat.setInputPaths(job,dir1 + "," + dir2+ ","+ dir3+ ","+ dir4);
    inFormat.setMinSplitSizeRack(BLOCKSIZE);
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test3): " + split);
    }
    expected.add(new Split(file4.getName(),BLOCKSIZE,0));
    expected.add(new Split(file4.getName(),BLOCKSIZE,BLOCKSIZE));
    expected.add(new Split(file4.getName(),BLOCKSIZE,BLOCKSIZE * 2));
    actual.clear();
    for (    InputSplit split : splits) {
      fileSplit=(CombineFileSplit)split;
      if (splits.size() == 3) {
        if (split.equals(splits.get(0))) {
          assertEquals(6,fileSplit.getNumPaths());
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts3[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(1))) {
          assertEquals(2,fileSplit.getNumPaths());
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(file2.getName(),fileSplit.getPath(0).getName());
          assertEquals(0,fileSplit.getOffset(0));
          assertEquals(BLOCKSIZE,fileSplit.getLength(0));
          assertEquals(file2.getName(),fileSplit.getPath(1).getName());
          assertEquals(BLOCKSIZE,fileSplit.getOffset(1));
          assertEquals(BLOCKSIZE,fileSplit.getLength(1));
          assertEquals(hosts2[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(2))) {
          assertEquals(1,fileSplit.getNumPaths());
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(file1.getName(),fileSplit.getPath(0).getName());
          assertEquals(0,fileSplit.getOffset(0));
          assertEquals(BLOCKSIZE,fileSplit.getLength(0));
          assertEquals(hosts1[0],fileSplit.getLocations()[0]);
        }
      }
 else       if (splits.size() == 2) {
        if (split.equals(splits.get(0))) {
          assertEquals(1,fileSplit.getLocations().length);
          if (fileSplit.getLocations()[0].equals(hosts2[0])) {
            assertEquals(5,fileSplit.getNumPaths());
          }
 else           if (fileSplit.getLocations()[0].equals(hosts3[0])) {
            assertEquals(6,fileSplit.getNumPaths());
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
        assertEquals(9,fileSplit.getNumPaths());
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
    assertEquals(9,actual.size());
    assertTrue(actual.containsAll(expected));
    inFormat=new DummyInputFormat();
    inFormat.setMinSplitSizeNode(BLOCKSIZE);
    inFormat.setMaxSplitSize(2 * BLOCKSIZE);
    FileInputFormat.setInputPaths(job,dir1 + "," + dir2+ ","+ dir3+ ","+ dir4);
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test4): " + split);
    }
    assertEquals(5,splits.size());
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
    assertEquals(9,actual.size());
    assertTrue(actual.containsAll(expected));
    verify(mockList,atLeastOnce()).add(hosts1[0]);
    verify(mockList,atLeastOnce()).add(hosts2[0]);
    verify(mockList,atLeastOnce()).add(hosts3[0]);
    inFormat=new DummyInputFormat();
    inFormat.setMinSplitSizeNode(BLOCKSIZE);
    inFormat.setMaxSplitSize(3 * BLOCKSIZE);
    FileInputFormat.setInputPaths(job,dir1 + "," + dir2+ ","+ dir3+ ","+ dir4);
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test5): " + split);
    }
    assertEquals(3,splits.size());
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
    assertEquals(9,actual.size());
    assertTrue(actual.containsAll(expected));
    verify(mockList,atLeastOnce()).add(hosts1[0]);
    verify(mockList,atLeastOnce()).add(hosts2[0]);
    inFormat=new DummyInputFormat();
    inFormat.setMaxSplitSize(4 * BLOCKSIZE);
    FileInputFormat.setInputPaths(job,dir1 + "," + dir2+ ","+ dir3+ ","+ dir4);
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test6): " + split);
    }
    assertEquals(3,splits.size());
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
    assertEquals(9,actual.size());
    assertTrue(actual.containsAll(expected));
    verify(mockList,atLeastOnce()).add(hosts1[0]);
    inFormat=new DummyInputFormat();
    inFormat.setMaxSplitSize(7 * BLOCKSIZE);
    inFormat.setMinSplitSizeNode(3 * BLOCKSIZE);
    inFormat.setMinSplitSizeRack(3 * BLOCKSIZE);
    FileInputFormat.setInputPaths(job,dir1 + "," + dir2+ ","+ dir3+ ","+ dir4);
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test7): " + split);
    }
    assertEquals(2,splits.size());
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
    assertEquals(9,actual.size());
    assertTrue(actual.containsAll(expected));
    verify(mockList,atLeastOnce()).add(hosts1[0]);
    inFormat=new DummyInputFormat();
    FileInputFormat.addInputPath(job,inDir);
    inFormat.setMinSplitSizeRack(1);
    inFormat.createPool(new TestFilter(dir1),new TestFilter(dir2));
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test1): " + split);
    }
    for (    InputSplit split : splits) {
      fileSplit=(CombineFileSplit)split;
      if (splits.size() == 2) {
        if (split.equals(splits.get(0))) {
          assertEquals(3,fileSplit.getNumPaths());
          expected.clear();
          expected.add(new Split(file1.getName(),BLOCKSIZE,0));
          expected.add(new Split(file2.getName(),BLOCKSIZE,0));
          expected.add(new Split(file2.getName(),BLOCKSIZE,BLOCKSIZE));
          actual.clear();
          for (int i=0; i < 3; i++) {
            String name=fileSplit.getPath(i).getName();
            long length=fileSplit.getLength(i);
            long offset=fileSplit.getOffset(i);
            actual.add(new Split(name,length,offset));
          }
          assertTrue(actual.containsAll(expected));
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts1[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(1))) {
          assertEquals(6,fileSplit.getNumPaths());
          expected.clear();
          expected.add(new Split(file3.getName(),BLOCKSIZE,0));
          expected.add(new Split(file3.getName(),BLOCKSIZE,BLOCKSIZE));
          expected.add(new Split(file3.getName(),BLOCKSIZE,BLOCKSIZE * 2));
          expected.add(new Split(file4.getName(),BLOCKSIZE,0));
          expected.add(new Split(file4.getName(),BLOCKSIZE,BLOCKSIZE));
          expected.add(new Split(file4.getName(),BLOCKSIZE,BLOCKSIZE * 2));
          actual.clear();
          for (int i=0; i < 6; i++) {
            String name=fileSplit.getPath(i).getName();
            long length=fileSplit.getLength(i);
            long offset=fileSplit.getOffset(i);
            actual.add(new Split(name,length,offset));
          }
          assertTrue(actual.containsAll(expected));
          assertEquals(1,fileSplit.getLocations().length);
        }
      }
 else       if (splits.size() == 3) {
        if (split.equals(splits.get(0))) {
          assertEquals(2,fileSplit.getNumPaths());
          expected.clear();
          expected.add(new Split(file2.getName(),BLOCKSIZE,0));
          expected.add(new Split(file2.getName(),BLOCKSIZE,BLOCKSIZE));
          actual.clear();
          for (int i=0; i < 2; i++) {
            String name=fileSplit.getPath(i).getName();
            long length=fileSplit.getLength(i);
            long offset=fileSplit.getOffset(i);
            actual.add(new Split(name,length,offset));
          }
          assertTrue(actual.containsAll(expected));
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts2[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(1))) {
          assertEquals(1,fileSplit.getNumPaths());
          assertEquals(file1.getName(),fileSplit.getPath(0).getName());
          assertEquals(BLOCKSIZE,fileSplit.getLength(0));
          assertEquals(0,fileSplit.getOffset(0));
          assertEquals(1,fileSplit.getLocations().length);
          assertEquals(hosts1[0],fileSplit.getLocations()[0]);
        }
        if (split.equals(splits.get(2))) {
          assertEquals(6,fileSplit.getNumPaths());
          expected.clear();
          expected.add(new Split(file3.getName(),BLOCKSIZE,0));
          expected.add(new Split(file3.getName(),BLOCKSIZE,BLOCKSIZE));
          expected.add(new Split(file3.getName(),BLOCKSIZE,BLOCKSIZE * 2));
          expected.add(new Split(file4.getName(),BLOCKSIZE,0));
          expected.add(new Split(file4.getName(),BLOCKSIZE,BLOCKSIZE));
          expected.add(new Split(file4.getName(),BLOCKSIZE,BLOCKSIZE * 2));
          actual.clear();
          for (int i=0; i < 6; i++) {
            String name=fileSplit.getPath(i).getName();
            long length=fileSplit.getLength(i);
            long offset=fileSplit.getOffset(i);
            actual.add(new Split(name,length,offset));
          }
          assertTrue(actual.containsAll(expected));
          assertEquals(1,fileSplit.getLocations().length);
        }
      }
 else {
        fail("Split size should be 2 or 3.");
      }
    }
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
    System.out.println("Elapsed time for " + numPools + " pools "+ " and "+ numFiles+ " files is "+ ((end - start) / 1000)+ " seconds.");
    inFormat=new DummyInputFormat();
    inFormat.setMaxSplitSize(BLOCKSIZE / 2);
    FileInputFormat.setInputPaths(job,dir3);
    splits=inFormat.getSplits(job);
    for (    InputSplit split : splits) {
      System.out.println("File split(Test8): " + split);
    }
    assertEquals(splits.size(),6);
  }
  finally {
    if (dfs != null) {
      dfs.shutdown();
    }
  }
}
