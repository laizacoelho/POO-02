# POO-II
# **Sistema Livraria**

Desenvolvido em Java com intuito de aplicar os conceitos de programação orientada a objeto contemplando os princípios de responsabilidade única (Single Responsiblity Principle) e aberto-fechado (Open-Closed Principle).  

## **Primeira etapa da atividade**

Foram criadas classes, interfaces e enums para criar, editar, deletar e ler cada tipo de produto, armazenando-os num estoque em forma de lista. Também foram criadas classes para o caixa e vendedor.  

**1. Sistema** 

Classe main do sistema da livraria. Usada para instanciar os produtos e estoque que o usuário deseja cadastrar e chamar as classes/métodos para executar suas respectivas ações. Para o funcionamento correto do programa, no início é necessário criar ao menos uma instancia de Estoque e Vendedor.  

### **Entidades relacionadas aos produtos da livraria:** 

**1. Produto**

Classe abstrata que define os atributos e métodos que todo produto deve implementar. Implementa as interfaces IGeradorId e Comparable. 

*Atributos:*

String nome; 

String id; 

Double preco; 

TipoProduto tipoProduto; 

*Métodos:*

Void geradorId () -> método sobrescrito da interface GeradorId, serve para gerar um id único para cada produto instanciado. 

Void lerProduto() -> método abstrato para ler cada produto de acordo com a especificidade de cada produto. 

Void editarProduto(Produto produto) -> método abstrato para editar produto existente de acordo com a especificidade de cada produto. 

Int compareTo (Produto outroProduto) -> método sobrescrito da interface Comparable, utilizado para listar os produtos conforme o tipo de produto.  

 

**2. AlbumMusical**

Classe filha de produto. Possui dois construtores, um considerando todos os atributos de álbum musical e o outro que contempla apenas nome, preço e id, para o caso de um cadastro mais rápido.  

*Atributos:*

List<String> musicos; 

List<String> selos; 

List<GeneroMusical> generosMusicais; 

*Métodos:*

Void lerProduto () -> sobrescrito da classe abstrata Produto, informa ao usuário todos os valores dos atributos de álbum musical. 

Void editarProduto(Produto produto) -> sobrescrito da classe abstrata Produto, recebe um Produto com os dados atualizados. 

 
**3. Brinquedo**

Classe filha de produto. Possui dois construtores, um considerando todos os atributos de brinquedo e o outro que contempla apenas nome, preço e id, para o caso de um cadastro mais rápido.  

*Atributos:*

TipoBrinquedo tipo; 

*Métodos:*

Void lerProduto () -> sobrescrito da classe abstrata Produto, informa ao usuário todos os valores dos atributos de brinquedo. 

Void editarProduto(Produto produto) -> sobrescrito da classe abstrata Produto, recebe um Produto com os dados atualizados. 
    
    
**4. Filme**

Classe filha de produto. Possui dois construtores, um considerando todos os atributos de livro e o outro que contempla apenas nome, preço e id, para o caso de um cadastro mais rápido.  

*Atributos:*

List<Genero> generos; 

List<String> escritores; 

String editora; 

*Métodos:*

Void lerProduto () -> sobrescrito da classe abstrata Produto, informa ao usuário todos os valores dos atributos de filme. 

Void editarProduto(Produto produto) -> sobrescrito da classe abstrata Produto, recebe um Produto com os dados atualizados. 

 

**5. Jogo**

Classe filha de produto. Possui dois construtores, um considerando todos os atributos de jogo e o outro que contempla apenas nome, preço e id, para o caso de um cadastro mais rápido.  

*Atributos:*

String distribuidora; 

List<String> generos; 

String estudio; 

*Métodos:* 

Void lerProduto () -> sobrescrito da classe abstrata Produto, informa ao usuário todos os valores dos atributos de jogo. 

Void editarProduto(Produto produto) -> sobrescrito da classe abstrata Produto, recebe um Produto com os dados atualizados. 

 

**6. Livro**

Classe filha de produto. Possui dois construtores, um considerando todos os atributos de livro e o outro que contempla apenas nome, preço e id, para o caso de um cadastro mais rápido.  

*Atributos:*

List<Genero> generos; 

List<String> escritores; 

String editora; 

*Métodos:*

Void lerProduto () -> sobrescrito da classe abstrata Produto, informa ao usuário todos os valores dos atributos de livro 

Void editarProduto(Produto produto) -> sobrescrito da classe abstrata Produto, recebe um Produto com os dados atualizados. 

 

**7. TipoProduto**

Enum que estabelece os tipos de produtos no sistema, cada tipo possui um número de índice. 

LIVRO (1), JOGO (2), FILME (3), BRINQUEDO (4) ALBUM_MUSICAL (5); 


**8. TipoBrinquedo**

Enum que estabelece os tipos de brinquedos sistema. 

PUZZLE, TABULEIRO, BONECO, BUILDING_BLOCK, ELETRONICO, CARRINHO; 

 

**9. Genero**

Enum que estabelece os tipos de gênero para os produtos que tem essa propriedade. 

ROMANCE, AVENTURA, FICCAO_CIENTIFICA, FANTASIA, SUSPENSE, COMEDIA, BIOGRAFIA, AUTOAJUDA, DOCUMENTARIO; 



**10. GeneroMusical**

Enum que estabelece os topos de gênero para os produtos do tipo álbum musical. 

POP, ROCK, SAMBA, MPB, JAZZ, CLASSICA, FORRO, FUNK, PAGODE, SERTANEJO, HIP_HOP; 

 
### **Entidades relacionadas ao estoque da livraria:**

**1. Estoque**

Classe para armazenar os produtos da livraria não havendo restrição por qualquer tipo de Produto, desde que seja um tipo cadastrado no TipoProduto (enum) e uma classe filha de Produto. 

Implementa a interface IGeradorId para gerar um id único para cada estoque instanciado.  Para o construtor é necessário apenas o atributo nome e o id é gerado automaticamente.  

*Atributos:* 

String nome; 

String idEstoque; 

List<Produto> produtos; 

List<Integer> quantidadeProduto; 

 
*Métodos:*

Void geradorId () -> método sobrescrito da interface GeradorId, serve para gerar um id único para cada estoque instanciado. 

Int localizaProduto (String idProduto) -> localiza um produto no estoque através do seu id, se achado retorna o índice deste produto na lista do estoque. Caso não encontrado retorna –1.  

Boolean produtoCadastradoNoEstoque (String idProduto) -> retorna true se existe o produto no estoque e false caso não exista.  

Void lerEstoque() -> imprime todos os produtos armazenados na lista do estoque. Chama o método lerProduto() da classe abstrata Produto que por sua vez irá executar de acordo com o tipo de instancia. Também imprime a quantidade daquele produto no estoque. 

Void lerEstoquePorCategoria (TipoProduto tipoProduto) -> imprime apenas os produtos do estoque do tipoProduto escolhido. Chama o método lerProduto() da classe abstrata Produto que por sua fez irá executar de acordo com o tipo de instancia. Também imprime a quantidade daquele produto no estoque. 

String getNome() -> método para ler o atributo privado nome. 

String getIdEstoque() -> método para ler o atributo privado idEstoque. 

 

**2. GerenciadorEstoque**

Classe apenas com métodos estáticos para realizar edições no Estoque. 

*Métodos:* 

Void adicionarProdutoEstoque (Estoque estoque, Produto produto, int quantidade) -> recebe a instância de um estoque para armazenar nele um produto e sua respectiva quantidade. Caso este produto já esteja cadastrado neste estoque ele atualiza a quantidade, somando a quantidade existente com nova quantidade informada.   

Void editarProdutoEstoque (Estoque estoque, Produto produto) -> deleta o produto informado do estoque desejado. Utiliza o método localizarProduto(id Produto) da classe estoque para receber a posição daquele produto na lista de produtos e quantidades.  

Void editarQuantidadeProdutoEstoque (Estoque estoque, String idProduto, int novaQuantidade) -> atualizada a quantidade de um produto no estoque escolhido.  

**3. IGeradorId**

Interface que pode ser implementada por qualquer classe que precise gerar um id. Esta interface é utilizada nas classes de Produto e Estoque, mas futuramente se necessário pode ser implantada também no Vendedor ou Caixa  

*Método:*

Void geradorId(); 

 

### **Entidades relacionadas às operações de compra/venda:**

**1. Vendedor**

Classe responsável pela a operação de venda, implementa a interface IVendedor. 

*Método:*

Void operacaoVenda (Estoque estoque, Produto produtoVendido, int quantidadeVendida) -> Método sobrescrito da interface IVendedor. Recebe o produto, quantidade e qual o estoque será realizada a operação de compra e venda. Verifica no estoque a existência deste produto e a quantidade disponível. Se a quantidade para venda for menor ou igual ao do estoque a operação é realizada e o caixa da livraria recebe a informação do valor da compra/venda. Caso o contrário a operação não é concluída e é informado ao usuário qual a quantidade disponível no estoque para a compra.  

**2. IVendedor**

Interface para ser implementada em classe que efetuam compra/venda. Foi criada pensando em ser utilizada em caso de se precisar usar a abstração ou numa expansão do sistema em que será necessário implantar outros tipos de vendedores.  

*Método:* 

OperacaoVenda (Estoque estoque, Produto produtoVendido, int quantidadeVendida) 

 

**3. Caixa** 

Classe que representa o caixa da livraria. Considerado um caixa único para receber todas as operações de compra/venda da livraria. Por isso a variável saldoCaixa foi declarada como estática, não sendo necessário ser instanciado um caixa específico para acesso o saldo do caixa da empresa. 

No seu construtor é iniciado o saldo inicial do caixa. 

*Atributos:* 

Double saldoCaixa; 

*Métodos:* 

Double getSaldoCaixa() -> método para ler o a variável privada saldoCaixa; 

Void receberCompra (double valorCompra) -> método estático que recebe o valor de um compra efetuada pelo vendedor e atualiza a variável saldoCaixa. 

 

## **Segunda etapa da atividade** 

Com a finalidade de cumprir os requisitos da segunda etapa da atividade foram criadas classes e interface de modo que fossem cumpridos o princípio aberto-fechado e as entidades originais não sofressem modificações.  

Foi criada a classe VendedorComDesconto para compras com desconto no preço e para cada produto foi criada uma classe filha do tipo Adulto, afim de atender o requisito de produtos que serão vendidos apenas para maiores de idade.  

Foi implantado um gerenciador de vendas que escolhe para cada operação de compra/venda qual o tipo de vendedor será acionado (Vendedor ou VendedorComDesconto). Também foi criada a classe Comprador, uma vez que agora é necessário checar as informações do comprador para operações de produtos para maior de idades.  

**1. Sistema**

Com as novas funções não é mais necessário instanciar um objeto do tipo Vendedor, ao invés disso será necessário fazer uma instância do GerenciadorDeVendas. Esta classe que irá por conta própria criar instâncias de Vendedores para realizar as operações.  

Também se tornou necessário criar uma instância da classe Comprador, uma vez que passou a ser necessário checar os dados de um comprador antes de realizar as operações de compra/venda. 

 

### **Entidades relacionadas aos produtos da livraria** 

**1. AlbumMusicalAdulto** 

Classe que herda de AlbumMusical. Nos seus construtores o atributo maiorDeIdade é definido como true.  

*Atributo* 

Boolean maiorDeIdade; 

 

**2. BrinquedoAdulto** 

Classe que herda de Brinquedo. Nos seus construtores o atributo maiorDeIdade é definido como true.  

*Atributo*

Boolean maiorDeIdade; 

 

**3. FilmeAdulto** 

Classe que herda de Filme. Nos seus construtores o atributo maiorDeIdade é definido como true.  

*Atributo* 

Boolean maiorDeIdade; 

 

**4. JogoAdulto** 

Classe que herda de Jogo. Nos seus construtores o atributo maiorDeIdade é definido como true.  

*Atributo* 

Boolean maiorDeIdade; 

 

**5. LivroAdulto** 

Classe que herda de Livro. Nos seus construtores o atributo maiorDeIdade é definido como true.  

*Atributo* 

Boolean maiorDeIdade; 

 

### **Entidades relacionadas às operações de compra/venda:** 

**1. VendedorComDesconto** 

Classe que herda da super classe Vendedor, sobrescreve o método de operação de venda com a finalidade de incluir um desconto na venda. 

*Atributos:*  

Double desconto 0; 

*Métodos:* 

Void operacaoVenda (Estoque estoque, Produto produtoVendido, int quantidadeVendida) -> sobrescreve este método da sua classe mãe, aplicando um desconto no valor da venda. Assim como o método da classe mãe, recebe qual o estoque será feito a operação com um produto e sua quantidade. Caso a quantidade requisitada para compra seja inferior à quantidade no estoque a operação é concluída conforme o valor de desconto recebido. Ao final este método envia para o caixa o valor da compra.  

Void setDesconto (double desconto) -> método para receber o valor do desconto da operação.  

**2. GerenciadorDeVendas** 

Classe que recebe o pedido de compra/venda e toma a decisão de qual tipo de Vendedor deve ser instanciado para realizar a requisição. Implementa a interface IGerenciadorDeVendas 

*Atributos:*  

Double desconto; 

*Métodos:* 

Void solicitar Venda (Estoque estoque, Produto produto, int quantidade, Comprador comprador) -> é um método sobrescrito de IGerenciadorDeVendas chama os métodos vendaEspecial e isVendaAutorizada para checar as condições dessa transação e de acordo com o retorno destes métodos define se deve ser instanciado a classe Vendedor ou VendedorComDesconto para realizar a compra/venda. Caso não exista o produto solicitado no estoque escolhido dá um retorno para o cliente que não existe este produto no estoque.  

Boolean  vendaEspecial (Estoque estoque, Produto produto, int quantidade) -> método sobrescrito da interface IGerenciadorDeVendas. Verifica se há alguma condição especial de desconto na compra. 

Boolean isVendaAutorizada (Comprado comprador, Produto produto) -> método sobrescrito da interface IGerenciadorDeVendas. Verifica se a compra solicitada é de um produto para adultos, se for chama o método verficarCompradorAdulto do objeto Comprador para confirmar se o Comprador é maior de idade.  

 

**3. IGerenciadorDeVendas** 

Interface criada para uso da abstração caso necessário ao longo do desenvolvimento do sistema. 

*Métodos:* 

Void solicitar Venda (Estoque estoque, Produto produto, int quantidade, Comprador comprador). 

Boolean  vendaEspecial (Estoque estoque, Produto produto, int quantidade). 

Boolean isVendaAutorizada (Comprado comprador, Produto produto). 

 

**4. Comprador**

Classe para criada para coletar os dados do comprador.  O construtor desta classe solicita todos os dados para preenchimento dos atributos.  

*Atributos:* 

String Nome; 

String rg; 

String cpf; 

LocalDate dataNascimento; 

 

*Métodos:* 

String getNome() -> método para ler atributo privado nome. 

LocalDate getDataNascimento() -> método para ler atributo privado dataNascimento. 

Boolean verificarCompradorAdulto() -> verifica se o comprado tem mais de 18 anos, se sim retorna true. 
