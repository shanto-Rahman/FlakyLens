@Test public void endToEndTest(){
  PojoClass pojoClass=PojoClassFactory.getPojoClass(ACompleteAbstractClass.class);
  Validator pojoValidator=ValidatorBuilder.create().with(new GetterMustExistRule()).with(new SetterMustExistRule()).with(new GetterTester()).with(new SetterTester()).build();
  pojoValidator.validate(pojoClass);
}
