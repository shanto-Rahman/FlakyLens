@Test public void testValueAnnotation(){
  String secret=context.getBean("secret",String.class);
  assertThat(secret).isEqualTo("the secret data.");
}
