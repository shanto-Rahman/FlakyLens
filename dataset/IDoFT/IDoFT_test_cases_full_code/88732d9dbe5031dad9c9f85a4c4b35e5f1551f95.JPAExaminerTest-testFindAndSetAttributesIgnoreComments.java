@Test public void testFindAndSetAttributesIgnoreComments(){
  ExaminerJPA jpaExaminer=new ExaminerJPA();
  JavaSource javaSource;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("Cocktail");
  sourceCode="//@Entity\n" + "//@Access(AccessType.FIELD)\n" + "public class Cocktail implements Comparable<Cocktail>\n"+ "{\n"+ "// @Id\n"+ "private String             id;\n"+ "private String             name;\n"+ "// @ManyToMany\n"+ "private Set<CocktailZutat> zutaten = new HashSet<CocktailZutat>();\n"+ "// @ManyToOne\n"+ "private CocktailZutat      basisZutat;\n"+ "public Cocktail(String id, String name)\n"+ "{\n"+ "this.id = id;\n"+ "this.name = name;\n"+ "}\n";
  javaSource.setSourceCode(sourceCode);
  jpaExaminer.examine(javaSource);
  assertEquals(0,DependencyContainer.getInstance().getDependencies(javaSource).size());
}
