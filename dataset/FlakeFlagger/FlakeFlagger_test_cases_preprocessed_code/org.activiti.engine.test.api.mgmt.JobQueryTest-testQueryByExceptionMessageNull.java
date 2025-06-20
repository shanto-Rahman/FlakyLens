public void testQueryByExceptionMessageNull(){
fail("ActivitiException expected");
assertEquals("Provided exception message is null",e.getMessage());
}