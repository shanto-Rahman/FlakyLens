@Test public void testDistcpLargeFile() throws Exception {
  FileEntry[] srcfiles={new FileEntry(SRCDAT,true),new FileEntry(SRCDAT + "/file",false)};
  final String testRoot="/testdir";
  final String testSrcRel=SRCDAT;
  final String testSrc=testRoot + "/" + testSrcRel;
  final String testDstRel=DSTDAT;
  final String testDst=testRoot + "/" + testDstRel;
  String nnUri=FileSystem.getDefaultUri(conf).toString();
  DistributedFileSystem fs=(DistributedFileSystem)FileSystem.get(URI.create(nnUri),conf);
  fs.mkdirs(new Path(testRoot));
  fs.mkdirs(new Path(testSrc));
  fs.mkdirs(new Path(testDst));
  long chunkSize=6;
  createFiles(fs,testRoot,srcfiles,chunkSize);
  String srcFileName=testRoot + Path.SEPARATOR + srcfiles[1].getPath();
  Path srcfile=new Path(srcFileName);
  if (!cluster.getFileSystem().exists(srcfile)) {
    throw new Exception("src not exist");
  }
  final long srcLen=fs.getFileStatus(srcfile).getLen();
  FileStatus[] srcstats=getFileStatus(fs,testRoot,srcfiles);
  for (int i=0; i < srcfiles.length; i++) {
    fs.setOwner(srcstats[i].getPath(),"u" + i,null);
  }
  String[] args=new String[]{"-blocksperchunk",String.valueOf(chunkSize),nnUri + testSrc,nnUri + testDst};
  LOG.info("_____ running distcp: " + args[0] + " "+ args[1]);
  ToolRunner.run(conf,new DistCp(),args);
  String realTgtPath=testDst;
  FileStatus[] dststat=getFileStatus(fs,realTgtPath,srcfiles);
  assertEquals("File length should match",srcLen,dststat[dststat.length - 1].getLen());
  this.compareFiles(fs,srcstats[srcstats.length - 1],dststat[dststat.length - 1]);
  deldir(fs,testRoot);
}
