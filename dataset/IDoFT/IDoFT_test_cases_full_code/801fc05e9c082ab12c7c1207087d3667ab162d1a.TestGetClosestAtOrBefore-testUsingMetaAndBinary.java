@Test public void testUsingMetaAndBinary() throws IOException {
  FileSystem filesystem=FileSystem.get(conf);
  Path rootdir=UTIL.getDataTestDirOnTestFS();
  TableDescriptorBuilder metaBuilder=UTIL.getMetaTableDescriptorBuilder().setMemStoreFlushSize(64 * 1024 * 1024);
  HRegion mr=HBaseTestingUtility.createRegionAndWAL(HRegionInfo.FIRST_META_REGIONINFO,rootdir,this.conf,metaBuilder.build());
  try {
    for (char c='A'; c < 'D'; c++) {
      HTableDescriptor htd=new HTableDescriptor(TableName.valueOf("" + c));
      final int last=128;
      final int interval=2;
      for (int i=0; i <= last; i+=interval) {
        HRegionInfo hri=new HRegionInfo(htd.getTableName(),i == 0 ? HConstants.EMPTY_BYTE_ARRAY : Bytes.toBytes((byte)i),i == last ? HConstants.EMPTY_BYTE_ARRAY : Bytes.toBytes((byte)i + interval));
        Put put=MetaTableAccessor.makePutFromRegionInfo(hri,EnvironmentEdgeManager.currentTime());
        put.setDurability(Durability.SKIP_WAL);
        mr.put(put);
      }
    }
    InternalScanner s=mr.getScanner(new Scan());
    try {
      List<Cell> keys=new ArrayList<>();
      while (s.next(keys)) {
        LOG.info(Objects.toString(keys));
        keys.clear();
      }
    }
  finally {
      s.close();
    }
    findRow(mr,'C',44,44);
    findRow(mr,'C',45,44);
    findRow(mr,'C',46,46);
    findRow(mr,'C',43,42);
    mr.flush(true);
    findRow(mr,'C',44,44);
    findRow(mr,'C',45,44);
    findRow(mr,'C',46,46);
    findRow(mr,'C',43,42);
    byte[] firstRowInC=HRegionInfo.createRegionName(TableName.valueOf("" + 'C'),HConstants.EMPTY_BYTE_ARRAY,HConstants.ZEROES,false);
    Scan scan=new Scan(firstRowInC);
    s=mr.getScanner(scan);
    try {
      List<Cell> keys=new ArrayList<>();
      while (s.next(keys)) {
        mr.delete(new Delete(CellUtil.cloneRow(keys.get(0))));
        keys.clear();
      }
    }
  finally {
      s.close();
    }
    findRow(mr,'C',44,-1);
    findRow(mr,'C',45,-1);
    findRow(mr,'C',46,-1);
    findRow(mr,'C',43,-1);
    mr.flush(true);
    findRow(mr,'C',44,-1);
    findRow(mr,'C',45,-1);
    findRow(mr,'C',46,-1);
    findRow(mr,'C',43,-1);
  }
  finally {
    HBaseTestingUtility.closeRegionAndWAL(mr);
  }
}
