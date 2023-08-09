package produto;

public class RepositorioProdutoArray<T extends Produto> implements IRepositorioProdutos<T>{

  private T[] produtos;
  private int index = -1;

	public RepositorioProdutoArray(int size) {
		this.produtos = (T[]) new Object[size];
	}

  private int procurarIndice(int codigo) {
    int i = 0;
    int out = -1;

    while (i <= index){
      if(produtos[i].getCodigo() == codigo){
        out = 1;
        break;
      }
    }
    return out;
    }

  @Override
  public boolean existe(int codigo) {
    int i = this.procurarIndice(codigo);
    return i != -1;
  }

  @Override
  public void inserir(T produto) {
    index = index+1;
    produtos[index] = produto;
  }

  @Override
  public void atualizar(T produto) {
    int i = this.procurarIndice(produto.getCodigo());
    if(i != -1) {
      produtos[i] = produto;
    } else {
      throw new RuntimeException("Produto não encontrado!");
    }
  }

  @Override
  public void remover(int codigo) {
    int i = this.procurarIndice(codigo);
    if(i != -1){
      produtos[i] = produtos[index];
      produtos[index] = null;
      index = index-1;
    } else {
       throw new RuntimeException("Produto não encontrado!");
    }
  }

  @Override
  public T procurar(int codigo) {
    int i = this.procurarIndice(codigo);
    if(i != -1){
      return produtos[i];
    }else {
      throw new RuntimeException("Produto não encontrado!");
    }
  }
  
}
