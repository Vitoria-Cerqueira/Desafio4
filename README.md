## Desafio 4 - Persistência de dados em Java
<hr>
O Sistema de Gerenciamento de Vendas é uma aplicação de console Java que permite aos usuários realizar operações relacionadas a clientes, 
vendedores, produtos e vendas.O sistema é dividido em várias camadas, incluindo controladores, modelos e repositórios, 
para garantir uma estrutura organizada e manutenível.
<hr>
<h2>Requisitos: </h2>
- Crie, no seu banco de dados todas as tabelas necessárias de um sistema responsável por registros de vendas de uma 
organização, insira valores nas tabelas e em seguida escreva as queries solicitadas abaixo.
OBS: Os valores em branco devem ser nulos no banco de dados. 

**Exemplo da tabela VENDAS:**

    Id_venda;
    Quantidade;
    Total;
    IdVendedor;
    IdCliente;
    IdProduto.	

**Os clientes devem ter:**

    Nome;
    Email; 
    CPF;
    Endereço. 

**Os vendedores devem ter:**

    Nome;
    Email;
    CPF;
    Salário.

**Queries:**

    Pesquise os itens que foram vendidos acima de 10,00;
    Altere o valor do VALOR_TOTAL (para zero) de todos os registros onde este campo é nulo.
    Pesquise o salário dos vendedores e ordene o resultado do maior salário para o menor.
    Exclua um cliente;
    Pesquisar quantos usuários tem o email zup.com.br 



## Funcionalidades Principais

O sistema possui as seguintes funcionalidades principais:

**Cliente**

- Registrar um novo cliente.
- Excluir um cliente existente.
- Ver o histórico de compras de um cliente.

**Vendedor**

- Registrar uma venda, incluindo a quantidade de produtos vendidos e o valor total.
- Visualizar produtos que foram vendidos por mais de dez reais.
- Atualizar o valor total de vendas para vendas com valores nulos.
- Exibir todas as vendas

**Gerente**

- Realizar login para acessar funcionalidades específicas.
- Visualizar e listar vendedores ordenados por salário em ordem decrescente.
- Visualizar e listar pessoas (clientes e vendedores) com emails da empresa.


**Script Query**

EXIBIR TODAS AS VENDAS COM VALOR TOTAL ACIMA DE 10,00

    SELECT product.name_product, sale.total
    FROM product, sale
    WHERE sale.idProduct = product.id_product
    AND sale.total > 10

Alterar valor total das vendas que estiverem null para 0

    UPDATE sale
    SET total = 0
    WHERE total IS NULL;

Mostrar o nome e salários dos vendendores em ordem decrescente

    SELECT seller.seller_name,seller.salary
    FROM seller
    ORDER BY seller.salary DESC;

Excluir um cliente sem inteferir na tabela de vendas

    DELETE FROM customer WHERE cpf = ?

Mostrar nome e email tanto de clientes e vendedores que tiverem o final: 'zup.com.br'

    SELECT seller_name, email
    FROM seller
    WHERE email LIKE '%@zup.com.br%'
    UNION
    SELECT customer_name, email
    FROM customer
    WHERE email LIKE '%@zup.com.br%';

Historico de compras

    SELECT product.name,sale.amount,sale.total
    FROM customer
    INNER JOIN sale ON customer.id_customer = sale.idCustomer
    INNER JOIN product ON product.id_product = sale.idProduct
    WHERE customer.cpf = ?

Registrar cliente

    INSERT INTO customer (name,email,cpf,address) VALUES (?,?,?,?) 

Login Gerente

    SELECT * FROM manager WHERE email=  ? AND password = ? 

Resgistrar produto

    INSERT INTO product(name,price) VALUES (?,?)

Mostrar vendas

    SELECT * FROM sale

Registrar venda

    INSERT INTO sale (amount,total,idSeller,idCustomer,idProduct) VALUES (?,?,?,?,?)




