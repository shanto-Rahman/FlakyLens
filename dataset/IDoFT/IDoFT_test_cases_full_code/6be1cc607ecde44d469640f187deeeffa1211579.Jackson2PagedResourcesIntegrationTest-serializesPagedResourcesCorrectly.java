/** 
 * @see SPR-13318
 */
@Test void serializesPagedResourcesCorrectly() throws Exception {
  assumeThat(SPRING_4_2_WRITE_METHOD).isNotNull();
  User user=new User();
  user.firstname="Dave";
  user.lastname="Matthews";
  PageMetadata metadata=new PagedModel.PageMetadata(1,0,2);
  PagedModel<User> resources=PagedModel.of(Collections.singleton(user),metadata);
  Method method=Sample.class.getMethod("someMethod");
  StringWriter writer=new StringWriter();
  HttpOutputMessage outputMessage=mock(HttpOutputMessage.class);
  when(outputMessage.getBody()).thenReturn(new WriterOutputStream(writer));
  when(outputMessage.getHeaders()).thenReturn(new HttpHeaders());
  MappingJackson2HttpMessageConverter converter=new MappingJackson2HttpMessageConverter();
  ReflectionUtils.invokeMethod(SPRING_4_2_WRITE_METHOD,converter,resources,method.getGenericReturnType(),MediaType.APPLICATION_JSON,outputMessage);
  assertThat(writer.toString()).isEqualTo(REFERENCE);
}
