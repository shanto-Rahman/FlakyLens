@Test public void doesNotTriggerDefaultRepositoryDetectionIfCustomized(){
assertNotNull(this.context.getBean(CityElasticsearchDbRepository.class));
}