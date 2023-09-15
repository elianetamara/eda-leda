package produto;

public interface IRepositorioProdutos<T extends Produto> {
  

	public boolean existe(int codigo);

	public void inserir(T produto);

	public void atualizar(T produto);

	public void remover(int codigo);

	public T procurar(int codigo);
}
