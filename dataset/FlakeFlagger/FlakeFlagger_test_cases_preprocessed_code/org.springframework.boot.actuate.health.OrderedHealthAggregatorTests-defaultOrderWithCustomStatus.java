@Test public void defaultOrderWithCustomStatus(){
assertEquals(Status.DOWN,this.healthAggregator.aggregate(healths).getStatus());
}