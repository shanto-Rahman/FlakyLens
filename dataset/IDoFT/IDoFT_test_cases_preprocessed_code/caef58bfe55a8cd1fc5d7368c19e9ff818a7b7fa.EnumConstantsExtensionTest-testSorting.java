@Test public void testSorting(){
Assert.assertEquals(new TypeScriptGenerator(settings).generateTypeScript(Input.from(Emotions.class,Direction.class)),new TypeScriptGenerator(settings).generateTypeScript(Input.from(Direction.class,Emotions.class)));
}