@Test public void cycleWithAutowiredFields() throws IOException {
  FailureAnalysis analysis=performAnalysis(CycleWithAutowiredFields.class);
  assertThat(analysis.getDescription()).startsWith("The dependencies of some of the beans in the application context form a cycle:");
  List<String> lines=readDescriptionLines(analysis);
  assertThat(lines).hasSize(9);
  assertThat(lines.get(0)).isEqualTo("The dependencies of some of the beans in the application context form a cycle:");
  assertThat(lines.get(1)).isEqualTo("");
  assertThat(lines.get(2)).isEqualTo("┌─────┐");
  assertThat(lines.get(3)).startsWith("|  three defined in " + BeanThreeConfiguration.class.getName());
  assertThat(lines.get(4)).isEqualTo("↑     ↓");
  assertThat(lines.get(5)).startsWith("|  one defined in " + CycleWithAutowiredFields.class.getName());
  assertThat(lines.get(6)).isEqualTo("↑     ↓");
  assertThat(lines.get(7)).startsWith("|  " + BeanTwoConfiguration.class.getName() + " (field private "+ BeanThree.class.getName());
  assertThat(lines.get(8)).isEqualTo("└─────┘");
}
