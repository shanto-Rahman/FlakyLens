@Test public void testFindAndSetAttributesIgnoreCommentBlocks(){
  JavaSource javaSource;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("CocktailModel");
  sourceCode="@Model\n" + "public class CocktailModel implements Serializable\n" + "{\n"+ "  private List<Cocktail>     nonAlcoholicCocktails;\n"+ "  private List<Cocktail>     alcoholicCocktails;\n"+ "  /*\n"+ "  @Inject\n"+ "  private CocktailRepository cocktailRepository;\n"+ "    */\n"+ "  public List<Cocktail> getNonAlcoholicCocktails()\n"+ "{\n"+ "return this.nonAlcoholicCocktails;\n"+ "}\n";
  javaSource.setSourceCode(sourceCode);
  JavaSourceContainer.getInstance().add(javaSource);
  JavaSourceInspector.getInstance().examine();
  assertEquals(0,DependencyContainer.getInstance().getDependencies(javaSource).size());
}
