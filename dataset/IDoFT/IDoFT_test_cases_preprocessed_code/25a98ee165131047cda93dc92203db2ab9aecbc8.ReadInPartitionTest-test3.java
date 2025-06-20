@Test public void test3() throws IOException, QueryFilterOptimizationException {
QueryDataSet queryDataSet=roTsFile.query(queryExpression,d1chunkGroupMetaDataOffsetList.get(0)[0],d1chunkGroupMetaDataOffsetList.get(0)[1]);//RW
Assert.assertEquals(ExpressionType.SERIES,transformedExpression.getType());
Assert.assertEquals(expected,transformedExpression.toString());
QueryDataSet queryDataSet_eq=roTsFile.query(queryExpression);//RW
Assert.assertEquals(r2.toString(),r.toString());
Assert.assertEquals(queryDataSet_eq.hasNext(),queryDataSet.hasNext());
}