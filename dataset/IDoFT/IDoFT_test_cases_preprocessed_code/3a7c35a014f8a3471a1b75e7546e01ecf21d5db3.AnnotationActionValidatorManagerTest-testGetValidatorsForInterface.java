public void testGetValidatorsForInterface(){
assertEquals(3,validatorList.size());
assertEquals("data",dataValidator1.getFieldName());
assertTrue(dataValidator1 instanceof RequiredFieldValidator);
assertEquals("data",dataValidator2.getFieldName());
assertTrue(dataValidator2 instanceof RequiredStringValidator);
assertEquals("bling",blingValidator.getFieldName());
assertTrue(blingValidator instanceof RequiredStringValidator);
}