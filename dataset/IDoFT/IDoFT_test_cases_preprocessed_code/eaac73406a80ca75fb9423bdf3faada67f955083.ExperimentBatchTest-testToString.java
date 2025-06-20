@Test public void testToString(){
String out="ExperimentBatch labels=" + labels + ", profile="+ profile+ ", personalizationParameters="+ personalizationParameters;//RW
assertEquals(expBatch.toString(),out);
}