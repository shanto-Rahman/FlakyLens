@Deployment public void testDivergingInclusiveGateway(){
if (i == 1) {
}
if (i <= 2) {
}
assertEquals(4 - i,tasks.size());
assertEquals(0,expectedNames.size());
}