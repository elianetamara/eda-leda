package formas;

public class Circulo implements FormaGeometrica{

  public double raio;

  public Circulo(double raio){
    this.raio = raio;
  }

  @Override
  public double area() {
    return (raio*raio)*Math.PI;
    }
  
}
