@Test public void implementAbstractToString(){
if (method.getName().equals("toString")) assertThat(method.isAbstract(),is(true));
assertThat(method.isAbstract(),is(true));
assertThat(abstractToString,notNullValue());
assertThat(actual,notNullValue());
assertThat(actual,startsWith(expected));
}