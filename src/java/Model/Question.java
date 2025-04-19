/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ryzen7
 */
public class Question {
  private String text, a, b, c, d, correct;

  public Question(String text, String a, String b, String c, String d, String correct) {
    this.text = text; this.a = a; this.b = b; this.c = c; this.d = d; this.correct = correct;
  }

  public String getText() { return text; }
  public String getA() { return a; }
  public String getB() { return b; }
  public String getC() { return c; }
  public String getD() { return d; }
  public String getCorrect() { return correct; }

    public Object getAnswer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

