@Test public void testDistcpLargeFile() throws Exception {
String nnUri=FileSystem.getDefaultUri(conf).toString();//RW
DistributedFileSystem fs=(DistributedFileSystem)FileSystem.get(URI.create(nnUri),conf);//RW
String srcFileName=testRoot + Path.SEPARATOR + srcfiles[1].getPath();//IT
if (!cluster.getFileSystem().exists(srcfile)) {//RW
}
ToolRunner.run(conf,new DistCp(),args);//RW
assertEquals("File length should match",srcLen,dststat[dststat.length - 1].getLen());
}