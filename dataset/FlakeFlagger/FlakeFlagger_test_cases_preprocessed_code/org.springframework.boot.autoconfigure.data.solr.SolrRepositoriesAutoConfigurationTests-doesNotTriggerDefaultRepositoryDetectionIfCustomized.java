@Test public void doesNotTriggerDefaultRepositoryDetectionIfCustomized(){
assertThat(this.context.getBean(CitySolrRepository.class),notNullValue());
}