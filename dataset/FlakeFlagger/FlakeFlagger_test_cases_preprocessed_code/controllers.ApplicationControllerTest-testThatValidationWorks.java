@Test public void testThatValidationWorks(){
assertEquals(response,"\"john@example.com\"");
assertEquals(response.trim(),"[{\"field\":\"email\",\"constraintViolation\":{\"messageKey\":\"validation.required.violation\",\"fieldKey\":\"email\",\"defaultMessage\":\"email is required\",\"messageParams\":[]}}]");
}