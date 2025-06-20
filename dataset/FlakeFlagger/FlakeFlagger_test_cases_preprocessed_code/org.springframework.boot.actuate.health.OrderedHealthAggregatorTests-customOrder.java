@Test public void customOrder(){
assertEquals(Status.UNKNOWN,this.healthAggregator.aggregate(healths).getStatus());
}