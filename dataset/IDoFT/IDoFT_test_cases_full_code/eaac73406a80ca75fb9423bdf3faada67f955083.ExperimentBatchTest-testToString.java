@Test public void testToString(){
  String out="ExperimentBatch labels=" + labels + ", profile="+ profile+ ", personalizationParameters="+ personalizationParameters;
  assertEquals(expBatch.toString(),out);
}
