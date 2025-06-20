@Test public void customOrderWithCustomStatus(){
assertEquals(Status.DOWN,this.healthAggregator.aggregate(healths).getStatus());
}