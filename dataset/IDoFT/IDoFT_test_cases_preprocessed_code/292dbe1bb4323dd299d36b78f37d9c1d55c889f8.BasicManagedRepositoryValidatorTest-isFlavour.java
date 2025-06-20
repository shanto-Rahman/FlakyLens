@Test void isFlavour(){
assertTrue(validator.isFlavour(ManagedRepository.class));
assertTrue(validator.isFlavour(BasicManagedRepository.class));
}