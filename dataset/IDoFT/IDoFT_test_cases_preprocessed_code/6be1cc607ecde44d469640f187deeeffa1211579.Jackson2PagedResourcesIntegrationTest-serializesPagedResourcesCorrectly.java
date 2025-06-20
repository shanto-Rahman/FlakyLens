/** 
 * @see SPR-13318
 */
@Test void serializesPagedResourcesCorrectly() throws Exception {
assumeThat(SPRING_4_2_WRITE_METHOD).isNotNull();//RW
ReflectionUtils.invokeMethod(SPRING_4_2_WRITE_METHOD,converter,resources,method.getGenericReturnType(),MediaType.APPLICATION_JSON,outputMessage);//RW
assertThat(writer.toString()).isEqualTo(REFERENCE);//RW
}