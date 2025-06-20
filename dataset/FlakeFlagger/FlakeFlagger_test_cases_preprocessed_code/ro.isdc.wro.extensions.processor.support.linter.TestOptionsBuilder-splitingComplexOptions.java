@Test public void splitingComplexOptions(){
assertEquals(6,result.length);
assertEquals(Arrays.toString(new String[]{"option1","option2","option3=['YUI','window','document','xui']","option4","option5=['YUI','xui']","option6"}),Arrays.toString(result));
}