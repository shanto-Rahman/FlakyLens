/** 
 * Test that governors, dependents, ancestors, descendants are all returned with multiplicity 1 if there are multiple paths to the same node.
 */
public void testComplicatedGraph(){
  SemanticGraph graph=makeComplicatedGraph();
  runTest("{} < {word:A}",graph,"B","C","D");
  runTest("{} > {word:E}",graph,"B","C","D");
  runTest("{} > {word:J}",graph,"I");
  runTest("{} < {word:E}",graph,"F","G","I");
  runTest("{} < {word:I}",graph,"J");
  runTest("{} << {word:A}",graph,"B","C","D","E","F","G","H","I","J");
  runTest("{} << {word:B}",graph,"E","F","G","H","I","J");
  runTest("{} << {word:C}",graph,"E","F","G","H","I","J");
  runTest("{} << {word:D}",graph,"E","F","G","H","I","J");
  runTest("{} << {word:E}",graph,"F","G","H","I","J");
  runTest("{} << {word:F}",graph,"H","I","J");
  runTest("{} << {word:G}",graph,"H","I","J");
  runTest("{} << {word:H}",graph,"I","J");
  runTest("{} << {word:I}",graph,"J");
  runTest("{} << {word:J}",graph);
  runTest("{} << {word:K}",graph);
  runTest("{} >> {word:A}",graph);
  runTest("{} >> {word:B}",graph,"A");
  runTest("{} >> {word:C}",graph,"A");
  runTest("{} >> {word:D}",graph,"A");
  runTest("{} >> {word:E}",graph,"A","B","C","D");
  runTest("{} >> {word:F}",graph,"A","B","C","D","E");
  runTest("{} >> {word:G}",graph,"A","B","C","D","E");
  runTest("{} >> {word:H}",graph,"A","B","C","D","E","F","G");
  runTest("{} >> {word:I}",graph,"A","B","C","D","E","F","G","H");
  runTest("{} >> {word:J}",graph,"A","B","C","D","E","F","G","H","I");
  runTest("{} >> {word:K}",graph);
}
