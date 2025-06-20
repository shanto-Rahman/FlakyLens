@Test public void testAspectsDelta(){
  BulkAspectResponse previousFileData=dataProvider.getBulkAspectMockedData(true);
  BulkAspectResponse currentFileData=dataProvider.getBulkAspectMockedData();
  AspectsDelta actualDelta=aspectDeltaProcessor.process(getIndexedData(previousFileData),getIndexedData(currentFileData));
  AspectsDelta expectedDelta=dataProvider.getExpectedResult();
  ReflectionAssert.assertReflectionEquals(expectedDelta,actualDelta,ReflectionComparatorMode.IGNORE_DEFAULTS);
}
