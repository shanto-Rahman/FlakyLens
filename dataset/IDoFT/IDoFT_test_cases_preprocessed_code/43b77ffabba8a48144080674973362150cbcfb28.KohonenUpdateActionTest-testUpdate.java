@Test public void testUpdate(){
Assert.assertTrue(dist.compute(bestBefore.getFeatures(),features) >= 0.2);
Assert.assertEquals(bestBefore,bestAfter);
Assert.assertEquals(0,dist.compute(bestAfter.getFeatures(),features),1e-16);
Assert.assertTrue(distancesAfter[i] < distancesBefore[i]);
}