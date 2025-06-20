@Test public void testCompaction(){
  rsm.updateCompaction(tableName,false,1,2,3,4,5);
  HELPER.assertCounter(pre + "compactionTime_num_ops",1,agg);
  HELPER.assertCounter(pre + "compactionInputFileCount_num_ops",1,agg);
  HELPER.assertCounter(pre + "compactionInputSize_num_ops",1,agg);
  HELPER.assertCounter(pre + "compactionOutputFileCount_num_ops",1,agg);
  HELPER.assertCounter(pre + "compactedInputBytes",4,agg);
  HELPER.assertCounter(pre + "compactedoutputBytes",5,agg);
  rsm.updateCompaction(tableName,false,10,20,30,40,50);
  HELPER.assertCounter(pre + "compactionTime_num_ops",2,agg);
  HELPER.assertCounter(pre + "compactionInputFileCount_num_ops",2,agg);
  HELPER.assertCounter(pre + "compactionInputSize_num_ops",2,agg);
  HELPER.assertCounter(pre + "compactionOutputFileCount_num_ops",2,agg);
  HELPER.assertCounter(pre + "compactedInputBytes",44,agg);
  HELPER.assertCounter(pre + "compactedoutputBytes",55,agg);
  rsm.updateCompaction(tableName,true,100,200,300,400,500);
  HELPER.assertCounter(pre + "compactionTime_num_ops",3,agg);
  HELPER.assertCounter(pre + "compactionInputFileCount_num_ops",3,agg);
  HELPER.assertCounter(pre + "compactionInputSize_num_ops",3,agg);
  HELPER.assertCounter(pre + "compactionOutputFileCount_num_ops",3,agg);
  HELPER.assertCounter(pre + "compactedInputBytes",444,agg);
  HELPER.assertCounter(pre + "compactedoutputBytes",555,agg);
  HELPER.assertCounter(pre + "majorCompactionTime_num_ops",1,agg);
  HELPER.assertCounter(pre + "majorCompactionInputFileCount_num_ops",1,agg);
  HELPER.assertCounter(pre + "majorCompactionInputSize_num_ops",1,agg);
  HELPER.assertCounter(pre + "majorCompactionOutputFileCount_num_ops",1,agg);
  HELPER.assertCounter(pre + "majorCompactedInputBytes",400,agg);
  HELPER.assertCounter(pre + "majorCompactedoutputBytes",500,agg);
}
