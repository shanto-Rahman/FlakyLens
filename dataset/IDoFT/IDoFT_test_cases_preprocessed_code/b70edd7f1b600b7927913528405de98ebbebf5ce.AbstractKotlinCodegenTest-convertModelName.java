@Test public void convertModelName(){
assertEquals(codegen.toModelName("$"),"Dollar");
assertEquals(codegen.toModelName("$$"),"DollarDollar");
assertEquals(codegen.toModelName("Pony?"),"PonyQuestionMark");
assertEquals(codegen.toModelName("$name"),"DollarName");
assertEquals(codegen.toModelName("nam#e"),"NamHashE");
assertEquals(codegen.toModelName("$another-fake?"),"DollarAnotherMinusFakeQuestionMark");
assertEquals(codegen.toModelName("Pony>=>="),"PonyGreaterThanEqualGreaterThanEqual");
}