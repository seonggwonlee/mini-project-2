package mini.project.server.pms.domain;

public class Test {

  private int firstAnswer;
  private int secondAnswer;
  private int thirdAnswer;
  private int fourthAnswer;
  private int fifthAnswer;
  private int count = 0;

  public int getFirstAnswer() {
    return firstAnswer;
  }
  public void setFirstAnswer(int firstAnswer) {
    this.firstAnswer = firstAnswer;
  }
  public int getSecondAnswer() {
    return secondAnswer;
  }
  public void setSecondAnswer(int secondAnswer) {
    this.secondAnswer = secondAnswer;
  }
  public int getThirdAnswer() {
    return thirdAnswer;
  }
  public void setThirdAnswer(int thirdAnswer) {
    this.thirdAnswer = thirdAnswer;
  }
  public int getFourthAnswer() {
    return fourthAnswer;
  }
  public void setFourthAnswer(int fourthAnswer) {
    this.fourthAnswer = fourthAnswer;
  }
  public int getFifthAnswer() {
    return fifthAnswer;
  }
  public void setFifthAnswer(int fifthAnswer) {
    this.fifthAnswer = fifthAnswer;
  }
  public int getCount () {
    return count;
  }

  public void setCount (int firstAnswer, int SecondAnswer,
      int ThirdAnswer, int FourthAnswer, int FifthAnswer) {
    this.count = firstAnswer + SecondAnswer + ThirdAnswer + FourthAnswer + FifthAnswer;
  }
}
