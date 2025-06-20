@Test public void testWriteEntityToHBase() throws Exception {
Configuration c1=util.getConfiguration();//RW
if (result != null && !result.isEmpty()) {
assertTrue(isRowKeyCorrect(row1,cluster,user,flow,runid,appName,entity));
assertEquals(id,id1);
assertEquals(type,type1);
assertEquals(cTime1,cTime);
assertEquals(infoMap,infoColumns);
assertEquals(isRelatedTo.get(isRelatedToEntry.getKey()).size(),isRelatedToValues.size());
assertTrue(isRelatedToValues.contains(v));
assertEquals(relatesTo.get(relatesToEntry.getKey()).size(),relatesToValues.size());
assertTrue(relatesToValues.contains(v));
assertEquals(conf,configColumns);
}
assertEquals(1,rowCount);
assertEquals(16,colCount);
assertNotNull(e1);
assertEquals(1,es1.size());
assertEquals(id,e1.getId());
assertEquals(type,e1.getType());
assertEquals(cTime,e1.getCreatedTime());
assertEquals(infoMap,infoMap2);
assertEquals(isRelatedTo,isRelatedTo2);
assertEquals(relatesTo,relatesTo2);
assertEquals(conf,conf2);
assertEquals(metrics,metrics2);
assertNotNull(e1);
assertEquals(id,e1.getId());
assertEquals(type,e1.getType());
assertEquals(cTime,e1.getCreatedTime());
assertEquals(infoMap,infoMap2);
assertEquals(isRelatedTo,e1.getIsRelatedToEntities());
assertEquals(relatesTo,e1.getRelatesToEntities());
assertEquals(conf,e1.getConfigs());
assertEquals(TimelineMetric.Type.SINGLE_VALUE,metric.getType());
assertEquals(1,metric.getValues().size());
assertTrue(metric.getValues().containsKey(ts - 20000));
assertEquals(metricValues.get(ts - 20000),metric.getValues().get(ts - 20000));
if (hbi != null) {
}
}