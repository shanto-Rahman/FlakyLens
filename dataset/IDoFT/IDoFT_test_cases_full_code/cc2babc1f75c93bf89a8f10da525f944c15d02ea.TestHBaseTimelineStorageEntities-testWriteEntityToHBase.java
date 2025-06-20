@Test public void testWriteEntityToHBase() throws Exception {
  TimelineEntities te=new TimelineEntities();
  TimelineEntity entity=new TimelineEntity();
  String id="hello";
  String type="world";
  entity.setId(id);
  entity.setType(type);
  Long cTime=1425016501000L;
  entity.setCreatedTime(cTime);
  Map<String,Object> infoMap=new HashMap<String,Object>();
  infoMap.put("infoMapKey1","infoMapValue1");
  infoMap.put("infoMapKey2",10);
  entity.addInfo(infoMap);
  String key="task";
  String value="is_related_to_entity_id_here";
  Set<String> isRelatedToSet=new HashSet<String>();
  isRelatedToSet.add(value);
  Map<String,Set<String>> isRelatedTo=new HashMap<String,Set<String>>();
  isRelatedTo.put(key,isRelatedToSet);
  entity.setIsRelatedToEntities(isRelatedTo);
  key="container";
  value="relates_to_entity_id_here";
  Set<String> relatesToSet=new HashSet<String>();
  relatesToSet.add(value);
  value="relates_to_entity_id_here_Second";
  relatesToSet.add(value);
  Map<String,Set<String>> relatesTo=new HashMap<String,Set<String>>();
  relatesTo.put(key,relatesToSet);
  entity.setRelatesToEntities(relatesTo);
  Map<String,String> conf=new HashMap<String,String>();
  conf.put("config_param1","value1");
  conf.put("config_param2","value2");
  entity.addConfigs(conf);
  Set<TimelineMetric> metrics=new HashSet<>();
  TimelineMetric m1=new TimelineMetric();
  m1.setId("MAP_SLOT_MILLIS");
  Map<Long,Number> metricValues=new HashMap<Long,Number>();
  long ts=System.currentTimeMillis();
  metricValues.put(ts - 120000,100000000);
  metricValues.put(ts - 100000,200000000);
  metricValues.put(ts - 80000,300000000);
  metricValues.put(ts - 60000,400000000);
  metricValues.put(ts - 40000,50000000000L);
  metricValues.put(ts - 20000,60000000000L);
  m1.setType(Type.TIME_SERIES);
  m1.setValues(metricValues);
  metrics.add(m1);
  entity.addMetrics(metrics);
  te.addEntity(new SubApplicationEntity(entity));
  HBaseTimelineWriterImpl hbi=null;
  try {
    Configuration c1=util.getConfiguration();
    hbi=new HBaseTimelineWriterImpl();
    hbi.init(c1);
    hbi.start();
    String cluster="cluster_test_write_entity";
    String user="user1";
    String subAppUser="subAppUser1";
    String flow="some_flow_name";
    String flowVersion="AB7822C10F1111";
    long runid=1002345678919L;
    String appName=HBaseTimelineSchemaUtils.convertApplicationIdToString(ApplicationId.newInstance(System.currentTimeMillis() + 9000000L,1));
    hbi.write(new TimelineCollectorContext(cluster,user,flow,flowVersion,runid,appName),te,UserGroupInformation.createRemoteUser(subAppUser));
    hbi.stop();
    Scan s=new Scan();
    byte[] startRow=new EntityRowKeyPrefix(cluster,user,flow,runid,appName).getRowKeyPrefix();
    s.setStartRow(startRow);
    s.setMaxVersions(Integer.MAX_VALUE);
    Connection conn=ConnectionFactory.createConnection(c1);
    ResultScanner scanner=new EntityTableRW().getResultScanner(c1,conn,s);
    int rowCount=0;
    int colCount=0;
    KeyConverter<String> stringKeyConverter=new StringKeyConverter();
    for (    Result result : scanner) {
      if (result != null && !result.isEmpty()) {
        rowCount++;
        colCount+=result.size();
        byte[] row1=result.getRow();
        assertTrue(isRowKeyCorrect(row1,cluster,user,flow,runid,appName,entity));
        String id1=ColumnRWHelper.readResult(result,EntityColumn.ID).toString();
        assertEquals(id,id1);
        String type1=ColumnRWHelper.readResult(result,EntityColumn.TYPE).toString();
        assertEquals(type,type1);
        Long cTime1=(Long)ColumnRWHelper.readResult(result,EntityColumn.CREATED_TIME);
        assertEquals(cTime1,cTime);
        Map<String,Object> infoColumns=ColumnRWHelper.readResults(result,EntityColumnPrefix.INFO,new StringKeyConverter());
        assertEquals(infoMap,infoColumns);
        for (        Map.Entry<String,Set<String>> isRelatedToEntry : isRelatedTo.entrySet()) {
          Object isRelatedToValue=ColumnRWHelper.readResult(result,EntityColumnPrefix.IS_RELATED_TO,isRelatedToEntry.getKey());
          String compoundValue=isRelatedToValue.toString();
          Set<String> isRelatedToValues=new HashSet<String>(Separator.VALUES.splitEncoded(compoundValue));
          assertEquals(isRelatedTo.get(isRelatedToEntry.getKey()).size(),isRelatedToValues.size());
          for (          String v : isRelatedToEntry.getValue()) {
            assertTrue(isRelatedToValues.contains(v));
          }
        }
        for (        Map.Entry<String,Set<String>> relatesToEntry : relatesTo.entrySet()) {
          String compoundValue=ColumnRWHelper.readResult(result,EntityColumnPrefix.RELATES_TO,relatesToEntry.getKey()).toString();
          Set<String> relatesToValues=new HashSet<String>(Separator.VALUES.splitEncoded(compoundValue));
          assertEquals(relatesTo.get(relatesToEntry.getKey()).size(),relatesToValues.size());
          for (          String v : relatesToEntry.getValue()) {
            assertTrue(relatesToValues.contains(v));
          }
        }
        Map<String,Object> configColumns=ColumnRWHelper.readResults(result,EntityColumnPrefix.CONFIG,stringKeyConverter);
        assertEquals(conf,configColumns);
        NavigableMap<String,NavigableMap<Long,Number>> metricsResult=ColumnRWHelper.readResultsWithTimestamps(result,EntityColumnPrefix.METRIC,stringKeyConverter);
        NavigableMap<Long,Number> metricMap=metricsResult.get(m1.getId());
        matchMetrics(metricValues,metricMap);
      }
    }
    assertEquals(1,rowCount);
    assertEquals(16,colCount);
    TimelineEntity e1=reader.getEntity(new TimelineReaderContext(cluster,user,flow,runid,appName,entity.getType(),entity.getId()),new TimelineDataToRetrieve(null,null,EnumSet.of(Field.ALL),Integer.MAX_VALUE,null,null));
    Set<TimelineEntity> es1=reader.getEntities(new TimelineReaderContext(cluster,user,flow,runid,appName,entity.getType(),null),new TimelineEntityFilters.Builder().build(),new TimelineDataToRetrieve(null,null,EnumSet.of(Field.ALL),Integer.MAX_VALUE,null,null));
    assertNotNull(e1);
    assertEquals(1,es1.size());
    assertEquals(id,e1.getId());
    assertEquals(type,e1.getType());
    assertEquals(cTime,e1.getCreatedTime());
    Map<String,Object> infoMap2=e1.getInfo();
    infoMap2.remove("FROM_ID");
    assertEquals(infoMap,infoMap2);
    Map<String,Set<String>> isRelatedTo2=e1.getIsRelatedToEntities();
    assertEquals(isRelatedTo,isRelatedTo2);
    Map<String,Set<String>> relatesTo2=e1.getRelatesToEntities();
    assertEquals(relatesTo,relatesTo2);
    Map<String,String> conf2=e1.getConfigs();
    assertEquals(conf,conf2);
    Set<TimelineMetric> metrics2=e1.getMetrics();
    assertEquals(metrics,metrics2);
    for (    TimelineMetric metric2 : metrics2) {
      Map<Long,Number> metricValues2=metric2.getValues();
      matchMetrics(metricValues,metricValues2);
    }
    e1=reader.getEntity(new TimelineReaderContext(cluster,user,flow,runid,appName,entity.getType(),entity.getId()),new TimelineDataToRetrieve(null,null,EnumSet.of(Field.ALL),null,null,null));
    assertNotNull(e1);
    assertEquals(id,e1.getId());
    assertEquals(type,e1.getType());
    assertEquals(cTime,e1.getCreatedTime());
    infoMap2=e1.getInfo();
    infoMap2.remove("FROM_ID");
    assertEquals(infoMap,infoMap2);
    assertEquals(isRelatedTo,e1.getIsRelatedToEntities());
    assertEquals(relatesTo,e1.getRelatesToEntities());
    assertEquals(conf,e1.getConfigs());
    for (    TimelineMetric metric : e1.getMetrics()) {
      assertEquals(TimelineMetric.Type.SINGLE_VALUE,metric.getType());
      assertEquals(1,metric.getValues().size());
      assertTrue(metric.getValues().containsKey(ts - 20000));
      assertEquals(metricValues.get(ts - 20000),metric.getValues().get(ts - 20000));
    }
    verifySubApplicationTableEntities(cluster,user,flow,flowVersion,runid,appName,subAppUser,c1,entity,id,type,infoMap,isRelatedTo,relatesTo,conf,metricValues,metrics,cTime,m1);
  }
  finally {
    if (hbi != null) {
      hbi.stop();
      hbi.close();
    }
  }
}
