@Test public void testListFormatting(){
assertEquals("\"myEvent\":[{\"name\":\"item1\",\"number1\":1235666,\"number2\":1.1231231},\n" + "{\"name\":\"item2\",\"number1\":2235666,\"number2\":1.0987987},\n" + "{\"name\":\"item3\",\"number1\":3235666,\"number2\":1.12312},\n"+ "{\"name\":\"item4\",\"number1\":4235666,\"number2\":1.51231}]",out.toString());
}