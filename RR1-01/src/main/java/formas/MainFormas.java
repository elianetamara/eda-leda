package formas;

public class MainFormas {

 public static void main(String[] args) {
  double a = 5.7;
  double b = 7.3;
  Circulo circulo = new Circulo(3);
  System.out.println(circulo.area());
  Triangulo triangulo = new Triangulo(b, a);
  System.out.println(triangulo.area());
  Retangulo retangulo = new Retangulo(a, b);
  System.out.println(retangulo.area());
  Quadrado quadrado = new Quadrado(a);
  System.out.println(quadrado.area());
 }
  
}
