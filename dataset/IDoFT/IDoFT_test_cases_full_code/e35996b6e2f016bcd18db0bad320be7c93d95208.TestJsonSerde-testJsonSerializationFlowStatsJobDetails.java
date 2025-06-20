@Test public void testJsonSerializationFlowStatsJobDetails() throws Exception {
  final short numJobsAppOne=3;
  final short numJobsAppTwo=4;
  final long baseStats=10L;
  Table historyTable=hbaseConnection.getTable(TableName.valueOf(Constants.HISTORY_TABLE));
  GenerateFlowTestData flowDataGen=new GenerateFlowTestData();
  flowDataGen.loadFlow("c1@local","buser","AppOne",1234,"a",numJobsAppOne,baseStats,idService,historyTable);
  flowDataGen.loadFlow("c2@local","Muser","AppTwo",2345,"b",numJobsAppTwo,baseStats,idService,historyTable);
  historyTable.close();
  JobHistoryService service=new JobHistoryService(UTIL.getConfiguration(),hbaseConnection);
  List<Flow> actualFlows=service.getFlowTimeSeriesStats("c1@local","buser","AppOne","",0L,0L,1000,null);
  ObjectMapper om=ObjectMapperProvider.createCustomMapper();
  om.configure(SerializationConfig.Feature.INDENT_OUTPUT,true);
  om.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,false);
  om.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
  ByteArrayOutputStream f=new ByteArrayOutputStream();
  om.writeValue(f,actualFlows);
  ByteArrayInputStream is=new ByteArrayInputStream(f.toByteArray());
  @SuppressWarnings("unchecked") List<Flow> deserFlows=(List<Flow>)JSONUtil.readJson(is,new TypeReference<List<Flow>>(){
  }
);
  assertFlowDetails(actualFlows,deserFlows);
}
