public void testAttributeConjunction(){
  String pattern="{$} > {pos:JJS;word:most}";
  comparePatternToString(pattern);
  SemgrexPattern semgrex=SemgrexPattern.compile(pattern);
  SemanticGraph graph=SemanticGraph.valueOf("[foo obj> most subj> bar dep> asdf]");
  runTest(semgrex,graph);
  graph.getNodeByIndex(1).setTag("JJS");
  runTest(semgrex,graph,"foo");
  graph.getNodeByIndex(1).setTag("NN");
  runTest(semgrex,graph);
  graph.getNodeByIndex(2).setTag("JJS");
  runTest(semgrex,graph);
  graph.getNodeByIndex(2).setWord("most");
  runTest(semgrex,graph,"foo");
}
