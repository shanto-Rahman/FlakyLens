@Test public void test(){
Assert.assertEquals("interface Person {\n" + "    name: string;\n" + "    email?: string;\n"+ "    age?: number;\n"+ "}",output.trim());
}