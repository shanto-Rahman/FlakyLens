@Test public void testJsonSerializationFlowStatsJobDetails() throws Exception {
Table historyTable=hbaseConnection.getTable(TableName.valueOf(Constants.HISTORY_TABLE));//RW
flowDataGen.loadFlow("c1@local","buser","AppOne",1234,"a",numJobsAppOne,baseStats,idService,historyTable);//RW
flowDataGen.loadFlow("c2@local","Muser","AppTwo",2345,"b",numJobsAppTwo,baseStats,idService,historyTable);//RW
JobHistoryService service=new JobHistoryService(UTIL.getConfiguration(),hbaseConnection);//RW
}