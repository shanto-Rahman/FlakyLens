@Test public void testFlush(){
  rsm.updateFlush(tableName,1,2,3);
  HELPER.assertCounter(pre + "flushTime_num_ops",1,agg);
  HELPER.assertCounter(pre + "flushMemstoreSize_num_ops",1,agg);
  HELPER.assertCounter(pre + "flushOutputSize_num_ops",1,agg);
  HELPER.assertCounter(pre + "flushedMemstoreBytes",2,agg);
  HELPER.assertCounter(pre + "flushedOutputBytes",3,agg);
  rsm.updateFlush(tableName,10,20,30);
  HELPER.assertCounter(pre + "flushTime_num_ops",2,agg);
  HELPER.assertCounter(pre + "flushMemstoreSize_num_ops",2,agg);
  HELPER.assertCounter(pre + "flushOutputSize_num_ops",2,agg);
  HELPER.assertCounter(pre + "flushedMemstoreBytes",22,agg);
  HELPER.assertCounter(pre + "flushedOutputBytes",33,agg);
}
