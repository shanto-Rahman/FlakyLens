@Test public void testiParameterized18nWithContextAndResult(){
assertEquals("this is the placeholder: test_parameter",messages.get("message_with_placeholder",context,Optional.of(result),"test_parameter").get());
assertEquals("this is the placeholder: test_parameter",messages.get("message_with_placeholder",context,Optional.of(result),"test_parameter").get());
assertEquals("this is the placeholder: test_parameter",messages.get("message_with_placeholder",context,Optional.of(result),"test_parameter").get());
assertEquals("das ist der platzhalter: test_parameter",messages.get("message_with_placeholder",context,Optional.of(result),"test_parameter").get());
assertEquals("das ist der platzhalter: test_parameter",messages.get("message_with_placeholder",context,Optional.of(result),"test_parameter").get());
assertEquals("cest le placeholder: test_parameter",messages.get("message_with_placeholder",context,Optional.of(result),"test_parameter").get());
assertEquals("das ist der platzhalter: test_parameter",messages.get("message_with_placeholder",context,Optional.of(result),"test_parameter").get());
}