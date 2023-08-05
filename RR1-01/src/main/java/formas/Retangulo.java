package formas;

public class Retangulo implements FormaGeometrica{


  private double base;

  private double altura;

  public Retangulo(double altura, double base){
    this.base = base;
    this.altura = altura;
  }


  @Override
  public double area() {
    return base*altura;
  }

  
  
}
