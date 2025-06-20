@Test public void defaultOrder(){
assertEquals(Status.DOWN,this.healthAggregator.aggregate(healths).getStatus());
}