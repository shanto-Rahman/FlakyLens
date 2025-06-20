@Test public void testCreateFromDoubles(){
assertEquals(0.5,distribution.probability(2),1e-15);
assertEquals(0.5,distribution.cumulativeProbability(1),0);
}