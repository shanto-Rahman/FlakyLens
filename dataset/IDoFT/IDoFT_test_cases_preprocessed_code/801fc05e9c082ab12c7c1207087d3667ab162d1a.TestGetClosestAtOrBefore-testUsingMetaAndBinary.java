@Test public void testUsingMetaAndBinary() throws IOException {
FileSystem filesystem=FileSystem.get(conf);//RW
Path rootdir=UTIL.getDataTestDirOnTestFS();//RW
TableDescriptorBuilder metaBuilder=UTIL.getMetaTableDescriptorBuilder().setMemStoreFlushSize(64 * 1024 * 1024);//RW
HRegion mr=HBaseTestingUtility.createRegionAndWAL(HRegionInfo.FIRST_META_REGIONINFO,rootdir,this.conf,metaBuilder.build());//RW
}