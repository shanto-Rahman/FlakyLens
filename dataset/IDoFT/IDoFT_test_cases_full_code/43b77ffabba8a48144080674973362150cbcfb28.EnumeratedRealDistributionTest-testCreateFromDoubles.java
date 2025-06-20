@Test public void testCreateFromDoubles(){
  final double[] data=new double[]{0,1,1,2,2,2};
  EnumeratedRealDistribution distribution=new EnumeratedRealDistribution(data);
  assertEquals(0.5,distribution.probability(2),0);
  assertEquals(0.5,distribution.cumulativeProbability(1),0);
}
