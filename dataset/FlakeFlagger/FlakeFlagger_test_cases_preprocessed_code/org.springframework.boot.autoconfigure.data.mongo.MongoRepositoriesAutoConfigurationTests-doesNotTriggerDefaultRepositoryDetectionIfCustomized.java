@Test public void doesNotTriggerDefaultRepositoryDetectionIfCustomized(){
assertNotNull(this.context.getBean(CityMongoDbRepository.class));
}