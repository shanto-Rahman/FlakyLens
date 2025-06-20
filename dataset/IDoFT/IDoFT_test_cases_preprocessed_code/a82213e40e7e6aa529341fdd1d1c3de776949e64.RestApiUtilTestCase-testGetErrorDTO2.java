@Test(description="Test get Error DTO as String") public void testGetErrorDTO2() throws Exception {
Assert.assertEquals(errorDTO1.toString(),expectedErrorDTOString1);
Assert.assertEquals(errorDTO2.toString(),expectedErrorDTOString2);
}