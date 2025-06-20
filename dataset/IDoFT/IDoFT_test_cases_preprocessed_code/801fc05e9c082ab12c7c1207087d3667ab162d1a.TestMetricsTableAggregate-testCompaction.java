@Test public void testCompaction(){
HELPER.assertCounter(pre + "compactionTime_num_ops",1,agg);//RW
HELPER.assertCounter(pre + "compactionInputFileCount_num_ops",1,agg);//RW
HELPER.assertCounter(pre + "compactionInputSize_num_ops",1,agg);//RW
HELPER.assertCounter(pre + "compactionOutputFileCount_num_ops",1,agg);//RW
HELPER.assertCounter(pre + "compactedInputBytes",4,agg);//RW
HELPER.assertCounter(pre + "compactedoutputBytes",5,agg);//RW
HELPER.assertCounter(pre + "compactionTime_num_ops",2,agg);//RW
HELPER.assertCounter(pre + "compactionInputFileCount_num_ops",2,agg);//RW
HELPER.assertCounter(pre + "compactionInputSize_num_ops",2,agg);//RW
HELPER.assertCounter(pre + "compactionOutputFileCount_num_ops",2,agg);//RW
HELPER.assertCounter(pre + "compactedInputBytes",44,agg);//RW
HELPER.assertCounter(pre + "compactedoutputBytes",55,agg);//RW
HELPER.assertCounter(pre + "compactionTime_num_ops",3,agg);//RW
HELPER.assertCounter(pre + "compactionInputFileCount_num_ops",3,agg);//RW
HELPER.assertCounter(pre + "compactionInputSize_num_ops",3,agg);//RW
HELPER.assertCounter(pre + "compactionOutputFileCount_num_ops",3,agg);//RW
HELPER.assertCounter(pre + "compactedInputBytes",444,agg);//RW
HELPER.assertCounter(pre + "compactedoutputBytes",555,agg);//RW
HELPER.assertCounter(pre + "majorCompactionTime_num_ops",1,agg);//RW
HELPER.assertCounter(pre + "majorCompactionInputFileCount_num_ops",1,agg);//RW
HELPER.assertCounter(pre + "majorCompactionInputSize_num_ops",1,agg);//RW
HELPER.assertCounter(pre + "majorCompactionOutputFileCount_num_ops",1,agg);//RW
HELPER.assertCounter(pre + "majorCompactedInputBytes",400,agg);//RW
HELPER.assertCounter(pre + "majorCompactedoutputBytes",500,agg);//RW
}