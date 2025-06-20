@Test public void testTimeSeriesDropOff() throws Exception {
  table.clear();
  long ts=System.currentTimeMillis();
  List<Tag> tags1=new ArrayList<>();
  tags1.add(new Tag("host","r01n01"));
  List<Tag> tags2=new ArrayList<>();
  tags2.add(new Tag("host","r01n02"));
  for (int i=0; i < 100; i++) {
    ts+=1000;
    Metric m=new Metric("sys.cpu.user",ts,i * 1.0D,tags1);
    byte[] row=MetricAdapter.encodeRowKey(m);
    Key k=new Key(row,tags1.get(0).join().getBytes(StandardCharsets.UTF_8),MetricAdapter.encodeColQual(ts,""),new byte[0],ts);
    Value v=new Value(MetricAdapter.encodeValue(m.getValue().getMeasure()));
    table.put(k,v);
    if (i < 50) {
      Metric m2=new Metric("sys.cpu.user",ts,i * 2.0D,tags2);
      byte[] row2=MetricAdapter.encodeRowKey(m2);
      Key k2=new Key(row2,tags2.get(0).join().getBytes(StandardCharsets.UTF_8),MetricAdapter.encodeColQual(ts,""),new byte[0],ts);
      Value v2=new Value(MetricAdapter.encodeValue(m2.getValue().getMeasure()));
      table.put(k2,v2);
    }
  }
  SortedMapIterator source=new SortedMapIterator(table);
  TimeSeriesGroupingIterator iter=new TimeSeriesGroupingIterator();
  IteratorSetting settings=new IteratorSetting(100,TimeSeriesGroupingIterator.class);
  settings.addOption(TimeSeriesGroupingIterator.FILTER,"0.20,0.20,0.20,0.20,0.20");
  iter.init(source,settings.getOptions(),SCAN_IE);
  iter.seek(new Range(),EMPTY_COL_FAMS,true);
  for (int i=4; i < 100; i++) {
    System.out.println(i);
    checkNextResult(iter,new double[]{i - 4,i - 3,i - 2,i - 1,i});
  }
  for (int i=4; i < 50; i++) {
    System.out.println(i);
    checkNextResult(iter,new double[]{(i - 4) * 2,(i - 3) * 2,(i - 2) * 2,(i - 1) * 2,i * 2});
  }
  assertFalse(iter.hasTop());
}
