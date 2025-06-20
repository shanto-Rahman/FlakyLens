@Test public void shouldComputeCorrectTotalNumberOfErrors(){
assertEquals(times * errorsPerResource,victim.getTotalFoundErrors());
assertEquals(times,victim.getTotalResourcesWithErrors());
}