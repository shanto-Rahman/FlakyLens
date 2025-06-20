@Test public void testFlush(){
HELPER.assertCounter(pre + "flushTime_num_ops",1,agg);//RW
HELPER.assertCounter(pre + "flushMemstoreSize_num_ops",1,agg);//RW
HELPER.assertCounter(pre + "flushOutputSize_num_ops",1,agg);//RW
HELPER.assertCounter(pre + "flushedMemstoreBytes",2,agg);//RW
HELPER.assertCounter(pre + "flushedOutputBytes",3,agg);//RW
HELPER.assertCounter(pre + "flushTime_num_ops",2,agg);//RW
HELPER.assertCounter(pre + "flushMemstoreSize_num_ops",2,agg);//RW
HELPER.assertCounter(pre + "flushOutputSize_num_ops",2,agg);//RW
HELPER.assertCounter(pre + "flushedMemstoreBytes",22,agg);//RW
HELPER.assertCounter(pre + "flushedOutputBytes",33,agg);//RW
}