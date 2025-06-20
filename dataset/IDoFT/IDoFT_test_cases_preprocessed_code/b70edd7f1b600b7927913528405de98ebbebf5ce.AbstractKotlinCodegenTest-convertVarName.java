@Test public void convertVarName() throws Exception {
assertEquals(codegen.toVarName("name"),"name");
assertEquals(codegen.toVarName("$name"),"dollarName");
assertEquals(codegen.toVarName("nam$$e"),"namDollarDollarE");
assertEquals(codegen.toVarName("user-name"),"userName");
assertEquals(codegen.toVarName("user_name"),"userName");
assertEquals(codegen.toVarName("user|name"),"userName");
assertEquals(codegen.toVarName("Pony?"),"ponyQuestionMark");
assertEquals(codegen.toVarName("nam#e"),"namHashE");
assertEquals(codegen.toVarName("Pony>=>="),"ponyGreaterThanEqualGreaterThanEqual");
assertEquals(codegen.toVarName("uSername"),"uSername");
assertEquals(codegen.toVarName("USERname"),"usERname");
assertEquals(codegen.toVarName("USERNAME"),"USERNAME");
assertEquals(codegen.toVarName("USER123NAME"),"USER123NAME");
}