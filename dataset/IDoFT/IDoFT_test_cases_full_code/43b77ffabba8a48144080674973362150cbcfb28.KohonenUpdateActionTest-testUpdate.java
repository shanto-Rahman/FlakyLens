@Test public void testUpdate(){
  final FeatureInitializer init=new OffsetFeatureInitializer(FeatureInitializerFactory.uniform(0,0.1));
  final FeatureInitializer[] initArray={init};
  final int netSize=3;
  final Network net=new NeuronString(netSize,false,initArray).getNetwork();
  final DistanceMeasure dist=new EuclideanDistance();
  final LearningFactorFunction learning=LearningFactorFunctionFactory.exponentialDecay(1,0.1,100);
  final NeighbourhoodSizeFunction neighbourhood=NeighbourhoodSizeFunctionFactory.exponentialDecay(3,1,100);
  final UpdateAction update=new KohonenUpdateAction(dist,learning,neighbourhood);
  final MapRanking rank=new MapRanking(net,dist);
  final double[] features=new double[]{0.3};
  final double[] distancesBefore=new double[netSize];
  int count=0;
  for (  Neuron n : net) {
    distancesBefore[count++]=dist.compute(n.getFeatures(),features);
  }
  final Neuron bestBefore=rank.rank(features,1).get(0);
  Assert.assertTrue(dist.compute(bestBefore.getFeatures(),features) >= 0.2);
  update.update(net,features);
  final double[] distancesAfter=new double[netSize];
  count=0;
  for (  Neuron n : net) {
    distancesAfter[count++]=dist.compute(n.getFeatures(),features);
  }
  final Neuron bestAfter=rank.rank(features,1).get(0);
  Assert.assertEquals(bestBefore,bestAfter);
  Assert.assertEquals(0,dist.compute(bestAfter.getFeatures(),features),1e-16);
  for (int i=0; i < netSize; i++) {
    Assert.assertTrue(distancesAfter[i] < distancesBefore[i]);
  }
}
