@Test public void test2() throws IOException, QueryFilterOptimizationException {
  ArrayList<Path> paths=new ArrayList<>();
  paths.add(new Path("d1","s6"));
  paths.add(new Path("d2","s1"));
  IExpression expression=new GlobalTimeExpression(TimeFilter.gt(50L));
  QueryExpression queryExpression=QueryExpression.create(paths,expression);
  QueryDataSet queryDataSet=roTsFile.query(queryExpression,d1chunkGroupMetaDataOffsetList.get(0)[0],d1chunkGroupMetaDataOffsetList.get(0)[1]);
  IExpression transformedExpression=queryExpression.getExpression();
  Assert.assertEquals(ExpressionType.GLOBAL_TIME,transformedExpression.getType());
  IExpression expectedTimeExpression=BinaryExpression.and(expression,d1s6timeRangeList.get(0).getExpression());
  String expected=ExpressionOptimizer.getInstance().optimize(expectedTimeExpression,queryExpression.getSelectedSeries()).toString();
  Assert.assertEquals(expected,transformedExpression.toString());
  QueryDataSet queryDataSet_eq=roTsFile.query(queryExpression);
  while (queryDataSet.hasNext() && queryDataSet_eq.hasNext()) {
    RowRecord r=queryDataSet.next();
    RowRecord r2=queryDataSet_eq.next();
    Assert.assertEquals(r2.toString(),r.toString());
  }
  Assert.assertEquals(queryDataSet_eq.hasNext(),queryDataSet.hasNext());
}
