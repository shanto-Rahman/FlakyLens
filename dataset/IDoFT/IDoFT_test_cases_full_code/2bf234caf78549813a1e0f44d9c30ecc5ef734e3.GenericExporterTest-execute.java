private void execute(List<String> expected,String genericExporterFolder,String aptFolder) throws IOException {
  List<String> failures=new ArrayList<String>();
  int successes=0;
  for (  File file : new File("target/" + genericExporterFolder + "/com/querydsl/apt/domain").listFiles()) {
    File other=new File("target/" + aptFolder + "/com/querydsl/apt/domain",file.getName());
    if (!other.exists() || !other.isFile()) {
      continue;
    }
    String result1=Files.toString(file,Charsets.UTF_8);
    String result2=Files.toString(other,Charsets.UTF_8);
    if (!result1.equals(result2)) {
      if (!expected.contains(file.getName())) {
        System.err.println(file.getName());
        failures.add(file.getName());
      }
 else {
        expected.remove(file.getName());
      }
    }
 else {
      successes++;
    }
  }
  expected.remove("QGeneric16Test_HidaBez.java");
  expected.remove("QGeneric4Test_HidaBez.java");
  expected.remove("QGeneric16Test_HidaBezGruppe.java");
  expected.remove("QGeneric4Test_HidaBezGruppe.java");
  if (!expected.isEmpty()) {
    fail("Following expected failures succeeded: " + expected);
  }
  if (!failures.isEmpty()) {
    for (    String failure : failures) {
      System.err.println(failure);
    }
    fail("Failed with " + failures.size() + " failures, "+ successes+ " succeeded, "+ failures);
  }
}
