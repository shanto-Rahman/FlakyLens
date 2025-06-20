/** 
 * Test some variations on negated attributes using negative lookahead regex 
 */
public void testNegatedAttribute(){
  SemanticGraph graph=SemanticGraph.valueOf("[ate subj>Bill obj>[muffins compound>blueberry]]");
  runTest("{word:/^(?!Bill).*$/}",graph,"ate","muffins","blueberry");
  graph.getNodeByIndex(0).setTag("NN");
  graph.getNodeByIndex(1).setTag("NN");
  graph.getNodeByIndex(2).setTag("JJS");
  graph.getNodeByIndex(3).setTag("NN");
  runTest("{pos:JJS}",graph,"muffins/JJS");
  runTest("{pos:JJS;word:muffins}",graph,"muffins/JJS");
  runTest("{pos:JJS;word:/^(?!Bill).*$/}",graph,"muffins/JJS");
  runTest("{pos:JJS;word:/^(?!muffins).*$/}",graph);
  runTest("{pos:/^(?!NN).*$/;word:muffins}",graph,"muffins/JJS");
  runTest("{pos:/^(?!JJS).*$/;word:/^(?!Bill).*$/}",graph,"ate/NN","blueberry/NN");
}
