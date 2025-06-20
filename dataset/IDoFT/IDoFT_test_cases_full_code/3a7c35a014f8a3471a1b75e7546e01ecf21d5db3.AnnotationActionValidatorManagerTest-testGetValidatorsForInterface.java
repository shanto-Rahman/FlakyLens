public void testGetValidatorsForInterface(){
  List validatorList=annotationActionValidatorManager.getValidators(AnnotationDataAware2.class,alias);
  assertEquals(3,validatorList.size());
  final FieldValidator dataValidator1=(FieldValidator)validatorList.get(0);
  assertEquals("data",dataValidator1.getFieldName());
  assertTrue(dataValidator1 instanceof RequiredFieldValidator);
  final FieldValidator dataValidator2=(FieldValidator)validatorList.get(1);
  assertEquals("data",dataValidator2.getFieldName());
  assertTrue(dataValidator2 instanceof RequiredStringValidator);
  final FieldValidator blingValidator=(FieldValidator)validatorList.get(2);
  assertEquals("bling",blingValidator.getFieldName());
  assertTrue(blingValidator instanceof RequiredStringValidator);
}
